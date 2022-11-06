package tkim.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends Listas<Cliente> {
	

	
	public String anadirCliente(String nombre, String domi, String nif, String mail, String tipoCliente, Listas<Cliente> listasClientes) {
		

		
			switch (tipoCliente) { 
					 
				case "1":
						 
					Cliente ClienteEstandar = new ClienteEstandar(nombre, domi, nif, mail);
					listasClientes.addDato(ClienteEstandar);
					
					return "El cliente ha ido añadido: " + ClienteEstandar.getNif() +" "+ ClienteEstandar.getNombre();
			
				case "2": 
					
					Cliente ClientePeremium = new ClientePremium(nombre, domi, nif, mail);
					listasClientes.addDato(ClientePeremium);
			
					return "El cliente ha ido añadido: " + ClientePeremium.getNif() +" "+ ClientePeremium.getNombre(); 
					
			}
			return tipoCliente;
	}

	// Metodo para comprobar si cliente existe
	public boolean existeCliente(String nif,Listas<Cliente> cli) {
			
			
			boolean existe = false;
			
				for (Cliente a : cli.getDato()) {
					if (a.getNif().equals(nif)) {
						existe = true;
						break;
					}
				}
			
			return existe;

		}
		

		
	//Metodos para Mostrar Clientes Estandar y Cliente Premium	
		
		public List<Cliente> mostrarClienteEstandar(Listas<Cliente> clientes) {
			
			List<Cliente> clientesEstandar = new ArrayList<>();
				for (Cliente var : clientes.getDato()) {
					if (var.tipoCliente() == "Cliente Estandar") {
						clientesEstandar.add(var);
					}
					
				}

			
			return clientesEstandar;
		}
		
		public List<Cliente> mostrarClientePremium(Listas<Cliente> clientes) {
			
			List<Cliente> showClientesPremium = new ArrayList<>();
				for (Cliente var : clientes.getDato()) {
					if (var.tipoCliente() == "Cliente Premium") {
						showClientesPremium.add(var);
					}
					
				}
			

			return showClientesPremium;
		}


}

