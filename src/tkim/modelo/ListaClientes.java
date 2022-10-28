package tkim.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends Listas<Cliente> {


	public String anadirCliente(String nombre, String domi, String nif, String mail, String tipoCliente,
			Listas<Cliente> cliente) {

	
	public String anadirCliente(String nombre, String domi, String nif, String mail, String tipoCliente, Listas<Cliente> listasClientes) {


		try {
			Cliente clientes = new ClienteEstandar(nombre, domi, nif, mail);
			cliente.addDato(clientes);
			return "El cliente ha sido añadido correctamente: " + clientes.getNombre();
		} catch (Exception e) {
			return "El cliente no ha podido introducirse correctamente";
		}


		
			switch (tipoCliente) { 
					 
				case "1":
						 
					Cliente ClienteEstandar = new ClienteEstandar(nombre, domi, nif, mail);
					listasClientes.addDato(ClienteEstandar);
					
					return "The Client was added: " + ClienteEstandar.getNif() +" "+ ClienteEstandar.getNombre();
			
				case "2": 
					
					Cliente ClientePeremium = new ClientePremium(nombre, domi, nif, mail);
					listasClientes.addDato(ClientePeremium);
			
					return "The Client was added: " + ClientePeremium.getNif() +" "+ ClientePeremium.getNombre(); 
					
			}
			return tipoCliente;

	public boolean ifExist(String nif, Listas<Cliente> c) {
		boolean existe = false;
		for (Cliente cliente : c.getDato()) {
			if (cliente.getNif().equals(nif)) {
				existe = true;

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

				break;
			}

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
		return existe;
	}

	public List<Cliente> mostrarClienteEstandar(Listas<Cliente> c) {
		List<Cliente> clientesStandard = new ArrayList<>();
		for (Cliente cliente : c.getDato()) {
			if (cliente.tipoCliente() == "Cliente Estandar") {
				clientesStandard.add(cliente);
			}
		}
		return clientesStandard;
	}
	
	public List<Cliente> mostrarClientePremium(Listas<Cliente> c) {
		List<Cliente> clientesPremium = new ArrayList<>();
		for (Cliente cliente : c.getDato()) {
			if (cliente.tipoCliente() == "Cliente Premium") {
				clientesPremium.add(cliente);
			}
		}
		return clientesPremium;
	}
	
	public Boolean existeCliente(String nif, Listas<Cliente> c) {
		Boolean existeCliente = false;
		for (Cliente cliente : c.getDato()) {
			if (cliente.getNif().equals(nif)) {
				existeCliente = true;
			}
		}
		
		return existeCliente;
	}

}
