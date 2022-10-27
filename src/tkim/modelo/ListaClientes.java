package tkim.modelo;

import java.util.List;

import tkim.controlador.Controlador;

public class ListaClientes extends Listas<Cliente> {
	

	
	public String addClientes(String nif, String nombre, String domicilio, String email, String tipoCliente, Listas<Cliente> listasClientes) {
		

		
			switch (tipoCliente) { 
					 
				case "1":
						 
					Cliente ClienteEstandar = new ClienteEstandar(nif, nombre, domicilio, email,tipoCliente);
					listasClientes.addDato(ClienteEstandar);
					
					return "The Client was added: " + ClienteEstandar.getNif() +" "+ ClienteEstandar.getNombre();
			
				case "2": 
					
					Cliente ClientePeremium = new ClientePremium(nif, nombre, domicilio, email, tipoCliente);
					listasClientes.addDato(ClientePeremium);
			
					return "The Client was added: " + ClientePeremium.getNif() +" "+ ClientePeremium.getNombre(); 
					
			}
			return tipoCliente;
	}




}




