package tkim.modelo;

import tkim.dao.ArticuloDAO;

public class FactoryDAOs {

	public static Object getDAO(String tipo) {
		
	switch (tipo) {
	case "Articulo":
		return new ArticuloDAO();	

	default: 
		return new ArticuloDAO();
		
	}

//		if (dao instanceof Articulo) {
//			return new ArticuloDAO();
//		} else if (dao instanceof Cliente) {
//			return null;
//		} else if (dao instanceof Pedido) {
//			return null;
//		}
//		
//		return null;
	}

}
