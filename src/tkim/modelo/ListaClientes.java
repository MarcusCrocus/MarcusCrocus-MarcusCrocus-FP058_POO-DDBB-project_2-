package tkim.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends Listas<Cliente> {

	public String anadirCliente(String nombre, String domi, String nif, String mail, String tipoCliente,
			Listas<Cliente> cliente) {
		
		try {
			Cliente clientes = new ClienteEstandar(nombre, domi, nif, mail);
			cliente.addDato(clientes);
			return "El cliente ha sido añadido correctamente: " + clientes.getNombre();
		} catch (Exception e) {
			return "El cliente no ha podido introducirse correctamente";
		}
	}

	public boolean ifExist(String nif, Listas<Cliente> c) {
		boolean existe = false;
		for (Cliente cliente : c.getDato()) {
			if (cliente.getNif().equals(nif)) {
				existe = true;

				break;
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
