package tkim.modelo;

import java.util.ArrayList;
import java.util.List;

public class Datos {

	private Listas<Cliente> clientes = new Listas<>();
	/*
	 * private Listas<Pedidos> pedidos = new Listas<> (); private Listas <Atriculos>
	 * articulos = new Listas<>();
	 */

	
	/**
	 * @return the clientes
	 */
	public Listas<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(Listas<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean serchCliente(String nif) {
		
		
		boolean existe = false;
		
			for (Cliente a : clientes.getDato()) {
				if (a.getNif().equals(nif)) {
					existe = true;
					break;
				}
			}
		
		return existe;

	}

	public List<Cliente> showClientesEstandar(Listas<Cliente> clientes) {
		
		List<Cliente> clientesEstandar = new ArrayList<>();
			for (Cliente var : clientes.getDato()) {
				if (var.tipoCliente() == "Cliente_Estandar") {
					clientesEstandar.add(var);
				}
				
			}
			
		
		
		
		return clientesEstandar;
	}



}