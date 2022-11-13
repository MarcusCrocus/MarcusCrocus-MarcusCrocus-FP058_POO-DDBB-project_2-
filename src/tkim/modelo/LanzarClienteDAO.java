package tkim.modelo;

import java.util.List;


import tkim.dao.IClientesDAO;

public class LanzarClienteDAO {

	public String anadirClientes(String nombre, String domi, String nif, String mail,String tipoCliente) {
		
		try {
			
			switch (tipoCliente) {
			
			case "1":
				Cliente cliEst = new ClienteEstandar (nombre, domi, nif, mail);
				IClientesDAO daoE = (IClientesDAO)FactoryDAOs.getDAO("Cliente");
				return daoE.anadirClientesDAO(cliEst);
				
			case "2":
				Cliente cliPrem = new ClientePremium (nombre, domi, nif, mail);
				IClientesDAO daoP = (IClientesDAO)FactoryDAOs.getDAO("Cliente");
				return daoP.anadirClientesDAO(cliPrem);
			}
			
		} catch (Exception e) {
			return "El Cliente no ha podido introducirse correctamente";
		}
		
		return "El Cliente se ha anadido correctamente";
		
	}
	
	public Boolean existeCliente(String nif) {
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.existeClienteDAO(nif);
		
	}


	public List<Cliente> mostrarClientesDAO() {
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.mostrarClientesDAO();
	}

	public Cliente buscarCliente(String codigo_cliente) {
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.buscarCliente(codigo_cliente);
	}










}
