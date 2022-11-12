package tkim.dao;

import java.util.List;

import tkim.modelo.Cliente;

public interface IClientesDAO {
	
	public String anadirClientesDAO(Cliente cli);
	public Boolean existeClienteDAO(String codigo);
	public List<Cliente> mostrarClientesDAO();
}
