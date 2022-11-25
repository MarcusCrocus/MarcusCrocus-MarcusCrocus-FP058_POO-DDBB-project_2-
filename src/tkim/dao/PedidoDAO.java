package tkim.dao;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import tkim.clasesEstaticas.QuerysEstaticas;
import tkim.conexionBBDD.ConexionMySQL;
import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.ClienteEstandar;
import tkim.modelo.ClientePremium;
import tkim.modelo.Pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PedidoDAO implements IPedidoDAO{
	
	ConexionMySQL cMySQL = new ConexionMySQL();
	Connection con = cMySQL.conectar();
	
	@Override
	public String addPedido(int numero_pedido, int unidades_pedido, LocalDateTime fecha_hora_pedido, Cliente cliente,
			Articulo articulo) {
		String mensaje = "El pedido no se ha podido meter";

		try {
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getInsertpedido());
			float total_pedido = unidades_pedido*articulo.getPrecioVenta();
			float gastosEnvio = articulo.getGastosEnvio();
			float descuentoPremium = cliente.descuentoEnv();
			String tc = cliente.tipoCliente().replace(" ","");
			if (tc.equals("ClientePremium")) {
				gastosEnvio -= (descuentoPremium*gastosEnvio)/100;
				total_pedido += gastosEnvio;
			}else {
				total_pedido += gastosEnvio;
			}
				
			ps.setInt(1, numero_pedido);
			ps.setInt(2, unidades_pedido);
			ps.setObject(3, fecha_hora_pedido);
			ps.setFloat(4, total_pedido);
			ps.setString(5, cliente.getNif());
			ps.setString(6, articulo.getCodigo());	 
			
			int resultado = ps.executeUpdate();
			if (resultado==1) {
				mensaje = "El pedido "+ numero_pedido +" ha sido introducido correctamente"; // 
			
			}

			return mensaje;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje = "Ha habido un fallo de conexion a BBDD";
			return mensaje;
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}
	
	
	@Override
	public Boolean existePedido(Integer codigo) {
		Boolean existePedido = false;

		ResultSet resultado = null;
		
		try {

			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelecpexiste());
			ps.setInt(1, codigo);
			resultado = ps.executeQuery();
			if (resultado.next()) {
				  if (resultado.getObject("numero_pedido") != null && !resultado.wasNull()) {
				    existePedido = true;
				  }
				}
			

			return existePedido;
		} catch (SQLException e) {
			e.printStackTrace();
			return existePedido;
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (resultado != null) {
				try {
					resultado.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public String eliminarPedido(int numPedido) {

        ResultSet resultado = null;
        String borrado = "El pedido no se ha podido borrar";
        
        try {

            PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectpedido());
            ps.setInt(1, numPedido);
            resultado = ps.executeQuery();
            if (resultado.next()) {
                  if (resultado.getObject("tiempo_preparacion") != null && !resultado.wasNull()) {
                    
                    int tpeparacion = resultado.getInt("tiempo_preparacion");
                    //String fecha_hora = resultado.getString("fecha_hora_pedido");    // se ha pasado a String
                    Timestamp fecha_hora =  (Timestamp) resultado.getObject("fecha_hora_pedido");
                    LocalDateTime localDateTime = fecha_hora.toLocalDateTime().minusHours(1);
                  
                    //DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    //LocalDateTime dateTime = LocalDateTime.parse(fecha_hora, formatter);
                    /*System.out.println(localDateTime);
                    System.out.println(LocalDateTime.now());*/
                    
                    
                      Duration duration = Duration.between(localDateTime, LocalDateTime.now());
                      long diff = Math.abs(duration.toMinutes());
                      //System.out.println("la diferencia en min:" + diff);
                      boolean enviado_pendiente = tpeparacion > diff;
                      
                      if (enviado_pendiente) {
                          PreparedStatement statment = con.prepareStatement(QuerysEstaticas.getDeletepedido());
                          statment.setInt(1,numPedido);
                          statment.execute();
                      
                          borrado = "El pedido ha sido eliminado";
                          System.out.println("");
                      }
                     
                
                      }
                  
                  
            } else {
                borrado = "El pedido introducido no existe";
              }
            
                  
            



           return borrado;
        } catch (SQLException e) {
            e.printStackTrace();
            return borrado;
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
	
	public List<Pedido> pedidosEnviados(String nif) {
		
		ResultSet resultado = null;
		String enviado = "no ha sido enviado";

		try {
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectpedidoporcliente());
			ps.setString(1, nif);
			resultado = ps.executeQuery();
			List<Pedido> totalPedidos = new ArrayList<>();
			List<Pedido> pedidosEnviados = new ArrayList<>();
			while (resultado.next()) {

				int numPedido = resultado.getInt(1);
				int unidadesPedido = resultado.getInt(2);
				Timestamp fechahoraPedido = (Timestamp) resultado.getObject(3);
				Float totalPedido = resultado.getFloat(4);
				String nifCliente = resultado.getString(5);
				String nombre = resultado.getString(6);
				String domicilio = resultado.getString(7);
				String email = resultado.getString(8);
				String tipocliente = resultado.getString(9);
				String codigoarticulo = resultado.getString(10);
				String descripcion = resultado.getString(11);
				Float precioVenta = resultado.getFloat(12);
				Float gastosEnvio = resultado.getFloat(13);
				int tiempoPreparacion = resultado.getInt(14);


				LocalDateTime localDateTime = fechahoraPedido.toLocalDateTime().minusHours(1);
				String tc = tipocliente.replace(" ","");
				Cliente cliente = null;
				
				if (tc.equals("ClientePremium")) {
					 cliente = new ClientePremium(nifCliente, nombre, domicilio, email);
				}else {
					 cliente = new ClienteEstandar(nifCliente, nombre, domicilio, email);
				}
				
				String ca = codigoarticulo.replace(" ","");
                Articulo articulo = new  Articulo(ca, descripcion, numPedido, unidadesPedido, tiempoPreparacion);
				
				
					

				Pedido pedido = new Pedido(numPedido, unidadesPedido, localDateTime, totalPedido, cliente, articulo);
				totalPedidos.add(pedido);
				
				

			}
			for (Pedido pedido : totalPedidos) {

				int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacion();
				LocalDateTime fechahorapedido = pedido.getFechaHoraPedido();

				Duration duration = Duration.between(fechahorapedido, LocalDateTime.now());
				long diff = Math.abs(duration.toMinutes());
				boolean enviados = tiempoPreparacion < diff;

				if (enviados) {
					pedidosEnviados.add(pedido);
				}

			}
			return pedidosEnviados;
		}

		catch (Exception e) {
			return null;
		}
	}
	
	public List<Pedido> pedidosPendientes(String nif) {

		Boolean existePedido = false;
		ResultSet resultado = null;
		String enviado = "no ha sido enviado";

		try {

			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectpedidoporcliente());
			ps.setString(1, nif);
			resultado = ps.executeQuery();
			List<Pedido> totalPedidos = new ArrayList<>();
			List<Pedido> pedidosEnviados = new ArrayList<>();
			while (resultado.next()) {

				int numPedido = resultado.getInt(1);
				int unidadesPedido = resultado.getInt(2);
				Timestamp fechahoraPedido = (Timestamp) resultado.getObject(3);
				Float totalPedido = resultado.getFloat(4);
				String nifCliente = resultado.getString(5);
				String nombre = resultado.getString(6);
				String domicilio = resultado.getString(7);
				String email = resultado.getString(8);
				String tipocliente = resultado.getString(9);
				String codigoarticulo = resultado.getString(10);
				String descripcion = resultado.getString(11);
				Float precioVenta = resultado.getFloat(12);
				Float gastosEnvio = resultado.getFloat(13);
				int tiempoPreparacion = resultado.getInt(14);


				LocalDateTime localDateTime = fechahoraPedido.toLocalDateTime().minusHours(1);
				String tc = tipocliente.replace(" ","");
				Cliente cliente = null;
				
				if (tc.equals("ClientePremium")) {
					 cliente = new ClientePremium(nifCliente, nombre, domicilio, email);
				}else {
					 cliente = new ClienteEstandar(nifCliente, nombre, domicilio, email);
				}
				
				String ca = codigoarticulo.replace(" ","");
                Articulo articulo = new  Articulo(ca, descripcion, numPedido, unidadesPedido, tiempoPreparacion);
				
				
					

				Pedido pedido = new Pedido(numPedido, unidadesPedido, localDateTime, totalPedido, cliente, articulo);
				totalPedidos.add(pedido);
				
				

			}
			for (Pedido pedido : totalPedidos) {

				int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacion();
				LocalDateTime fechahorapedido = pedido.getFechaHoraPedido();

				Duration duration = Duration.between(fechahorapedido, LocalDateTime.now());
				long diff = Math.abs(duration.toMinutes());
				boolean enviados = tiempoPreparacion > diff;

				if (enviados) {
					pedidosEnviados.add(pedido);
				}

			}
			return pedidosEnviados;
		}

		catch (Exception e) {
			return null;
		}
	}
}
