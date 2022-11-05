package tkim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tkim.clasesEstaticas.QuerysEstaticas;
import tkim.modelo.Articulo;

public class ArticuloDAO implements IArticuloDAO {
    
    private void registerDriver() {
        try {
            Class.forName(QuerysEstaticas.getJdbcDriver()).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
        }
    }


	@Override
	public String addArticulos(Articulo articulo) {
		registerDriver();
		String mensaje = "El articulo no se ha podido meter";
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getInsert());
			ps.setString(1, articulo.getCodigo());
			ps.setString(2, articulo.getDescripcion());
			ps.setFloat(3, articulo.getPrecioVenta());
			ps.setFloat(4, articulo.getGastosEnvio());
			ps.setInt(5, articulo.getTiempoPreparacion());
			int resultado = ps.executeUpdate();
			if (resultado==1) {
				mensaje = "El articulo "+articulo.getDescripcion()+"ha sido introducido correctamente";
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
	public List<Articulo> mostrarArticulos() {
		registerDriver();
		Connection con = null;
		ResultSet rs = null;
		List <Articulo> articulos = null;
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelectall());
			rs = ps.executeQuery();
			articulos = new ArrayList<Articulo>();
			while (rs.next()) {
				String ca = rs.getString("codigo_articulo");
			    String des = rs.getString("descripcion");
			    float precio_venta = rs.getFloat("precio_venta");
			    float gastos_envio = rs.getFloat("gastos_envio");
			    int tiempo_preparacion =rs.getInt("tiempo_preparacion");	
			    Articulo articulo = new Articulo(ca, des, precio_venta, gastos_envio, tiempo_preparacion);
			    articulos.add(articulo);
			}
			return articulos;
		} catch (SQLException e) {
			e.printStackTrace();
			return articulos;
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
	
	public Boolean existeArticulo(String codigo) {
		Boolean existeArticulo = false;
		registerDriver();
		Connection con = null;
		ResultSet resultado = null;
		
		try {
			con = DriverManager.getConnection(QuerysEstaticas.getDbUrl());
			PreparedStatement ps = con.prepareStatement(QuerysEstaticas.getSelecexiste());
			ps.setString(1, codigo);
			resultado = ps.executeQuery();
			if (resultado.next()) {
				  if (resultado.getObject("codigo_articulo") != null && !resultado.wasNull()) {
				    existeArticulo = true;
				  }
				}
			

			return existeArticulo;
		} catch (SQLException e) {
			e.printStackTrace();
			return existeArticulo;
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
