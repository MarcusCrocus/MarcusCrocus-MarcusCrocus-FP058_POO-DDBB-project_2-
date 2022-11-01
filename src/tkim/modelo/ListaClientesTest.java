package tkim.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tkim.controlador.Controlador;

class ListaClientesTest {
	Controlador ctrl;
	ListaClientes listaClientes;
	Cliente cliente;

	@Test
    void testAnadirClienteEstandar() {
        ctrl = new Controlador();
        listaClientes = new ListaClientes();
        
        
        cliente = new ClienteEstandar("pepito", "Barcelona", "x78946", "ajf;lad@kajf.com");
        ctrl.getDatos().getClientes().addDato(cliente);
 
        assertEquals("el return no es correcto: ", listaClientes.anadirCliente("pepito", "Barcelona", "x78946", "ajf;lad@kajf.com", "1", ctrl.getDatos().getClientes()), "El cliente ha ido añadido: " + cliente.getNif() +" "+ cliente.getNombre());
    }
}
