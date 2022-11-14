package tkim.dao;

import tkim.clasesEstaticas.QuerysEstaticas;
import tkim.modelo.Cliente;
import tkim.modelo.ClienteEstandar;
import tkim.modelo.ClientePremium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClientesDAO {
	
    private void registerDriver() {
        try {
            Class.forName(QuerysEstaticas.getJdbcDriver()).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
    }

	@Override
	public String anadirClientesDAO(Cliente cli) {
		
		registerDriver();
		String message = "El Cliente no se ha podido ser anadido";
		Connection con = null;
		
		try {
			
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getInsertcliente());
			
			ps.setString(1, cli.getNif());
			ps.setString(2, cli.getNombre());
			ps.setString(3, cli.getDomicilio());
			ps.setString(4, cli.getEmail());
			ps.setString(5, cli.tipoCliente());
			ps.setFloat(6, cli.calcAnual());
			ps.setFloat(7, cli.descuentoEnv());
			
			int result = ps.executeUpdate();
			
				if (result == 1) {
					message ="El Cliente "+cli.getNombre()+" ha sido anadido correctamente";
				}

			return message;
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "Ha habido un fallo de conexion a BBDD";
			return message;
			
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
	public Boolean existeClienteDAO(String nif) {
		Boolean existeCliente = false;
		registerDriver();
		Connection con = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectexistecliente());
			
			ps.setString(1, nif); //si existe en queries el parametro 1
			result = ps.executeQuery();
				if (result.next()) {
					if (result.getObject("nif") !=null && !result.wasNull()) {
						existeCliente = true;
					}
				}
				return existeCliente;
				
		} catch (Exception e) {
			e.printStackTrace();
			return existeCliente;
			
		}finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (result != null) {
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public List<Cliente> mostrarClientesXtipo(String tipoCliente) {
		registerDriver();
		Connection con = null;
		ResultSet rs = null;
		List <Cliente> clientes = null;
		
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelecttipocliente());
			ps.setString(1, tipoCliente);
			rs = ps.executeQuery();
			clientes = new ArrayList<Cliente>();
			
				while (rs.next()) {
					String nif = rs.getString(1);
					String nombre = rs.getString(2);
					String domi = rs.getString(3);
					String email = rs.getString(4);
					String tipo_cli = rs.getString(5);
					Float cuotaAnual = rs.getFloat(6);
					Float descuento_env = rs.getFloat(7);
					
					Cliente cli = new ClienteEstandar(nif, nombre, domi, email);
					
					clientes.add(cli);
				}
				return clientes;
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return clientes;
			
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
	public Cliente buscarCliente(String nif) {
		//buscas cliente en BBDD por nif
		//del resulset miras que tipo de cliente es y haces el if/else
		/*String tc = tipo_cli.replace(" ","");
		if tipocliente estandar
		Cliente cliente = new ClienteEstandar(nif, nombre, domicilio, email);
		else
		Cliente cliente = new ClientePremium(nif, nombre, domicilio, email);*/
		//miras que tipo de cliente es y haces un if para meterlo como estandar o como premium
		return null;
	}

	@Override
	public List<Cliente> mostrarClientesTodos() {
		registerDriver();
		Connection con = null;
		ResultSet rs = null;
		List <Cliente> clientes = null;
		
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectclientestodos());
			rs = ps.executeQuery();
			Cliente cli = null;
			clientes = new ArrayList<Cliente>();
			
				while (rs.next()) {
					String nif = rs.getString(1);
					String nombre = rs.getString(2);
					String domi = rs.getString(3);
					String email = rs.getString(4);
					String tipo_cli = rs.getString(5);
					Float cuotaAnual = rs.getFloat(6);
					Float descuento_env = rs.getFloat(7);
					String tc = tipo_cli.replace(" ","");
					if (tc.equals("ClientePremium")) {
						cli = new ClientePremium(nif, nombre, domi, email);
					} else {
						cli = new ClienteEstandar(nif, nombre, domi, email);
					}
					
					clientes.add(cli);
				}
				return clientes;
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return clientes;
			
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




	

    


}
