package tkim.controlador;

import java.util.List;

import tkim.modelo.*;
import tkim.vista.*;


public class Controlador {
	
	ListaClientes lc = new ListaClientes();
	Datos dt = new Datos();
	
	
	public String dInput(String nif, String nombre, String domicilio, String email, String tipoCliente) {
		
		return lc.addClientes(nif,nombre,domicilio,email,tipoCliente, dt.getClientes());
	}


	public boolean existeCliente(String nif) {

		return dt.serchCliente(nif);
	}

	
	  public List<Cliente> clienteEstandar() { 
		  return dt.showClientesEstandar(dt.getClientes());
	  
	  }
	 



	

}
	

