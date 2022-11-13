package tkim.dao;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import tkim.clasesEstaticas.QuerysEstaticas;
import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class PedidoDAO implements IPedidoDAO{
	
	   private void registerDriver() {
	        try {
	            Class.forName(QuerysEstaticas.getJdbcDriver()).newInstance();
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
	            e.printStackTrace();
	        }
	    }
	   

	@Override
	public String addPedido(int numero_pedido, int unidades_pedido, LocalDateTime fecha_hora_pedido, Cliente cliente,
			Articulo articulo) {
		registerDriver();
		String mensaje = "El pedido no se ha podido meter";
		Connection con = null;
		try {
						
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getInsertpedido());
			float total_pedido = unidades_pedido*articulo.getPrecioVenta();
			float gastosEnvio = articulo.getGastosEnvio();
			float descuentoPremium = cliente.descuentoEnv();
			if (cliente.tipoCliente().equals("Cliente Premium")) {
				gastosEnvio -= (descuentoPremium*gastosEnvio)/100;
				total_pedido += gastosEnvio;
			}else {
				total_pedido += gastosEnvio;
			}	
			if (existePedido(numero_pedido)) {
				System.out.println("Pedido con este numero ya existe");
				
			} else {
				
				DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
				String formattedDateTime = fecha_hora_pedido.format(formatter);
				
				ps.setInt(1, numero_pedido);
				ps.setInt(2, unidades_pedido);
				ps.setString(3, formattedDateTime);
				ps.setFloat(4, total_pedido);
				ps.setString(5, cliente.getNif());
				ps.setString(6, articulo.getCodigo());	 
				
				int resultado = ps.executeUpdate();
				if (resultado==1) {
					mensaje = "El pedido "+ numero_pedido +" ha sido introducido correctamente"; // 
				
				}
		
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
		registerDriver();
		Connection con = null;
		ResultSet resultado = null;
		
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
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
        registerDriver();
        Connection con = null;
        Boolean existePedido = false;
        ResultSet resultado = null;
        String borrado = "El pedido no se ha podido borrar";
        
        try {
            con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
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
                    System.out.println(localDateTime);
                    System.out.println(LocalDateTime.now());
                    
                    
                      Duration duration = Duration.between(localDateTime, LocalDateTime.now());
                      long diff = Math.abs(duration.toMinutes());
                      System.out.println("la diferencia en min:" + diff);
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
}
