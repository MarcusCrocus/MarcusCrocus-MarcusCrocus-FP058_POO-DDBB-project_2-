package tkim.modelo;

import java.util.List;


import tkim.dao.IClientesDAO;

public class LanzarClienteDAO {

	public String anadirClientes(String nif, String nombre, String domi, String mail,String tipoCliente) {
		
		try {
			
			switch (tipoCliente) {
			
			case "1":
				Cliente cliEst = new ClienteEstandar (nif, nombre, domi, mail);
				IClientesDAO daoE = (IClientesDAO)FactoryDAOs.getDAO("Cliente");
				return daoE.anadirClientesDAO(cliEst);
				
			case "2":
				Cliente cliPrem = new ClientePremium (nif, nombre, domi, mail);
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


	public List<Cliente> mostrarClientesXtipo(String tipoCliente) {
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.mostrarClientesXtipo(tipoCliente);
	}
	
	public List<Cliente> mostrarClientesTodos(){
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.mostrarClientesTodos();
	}

	public Cliente buscarCliente(String codigo_cliente) {
		IClientesDAO dao = (IClientesDAO) FactoryDAOs.getDAO("Cliente");
		return dao.buscarCliente(codigo_cliente);
	}










}
