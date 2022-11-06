package tkim.modelo;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import tkim.controlador.Controlador;

class ListaClientesTest {


	ListaClientes listaCli;
	Cliente clientVar;
	Controlador ctrl;
	

	@Test 
    void testAnadirClienteEstandar() {
		
		//isra correction
        ctrl = new Controlador();
        listaCli = new ListaClientes();
        
        
        clientVar = new ClienteEstandar("pepito", "Barcelona", "x78946", "ajf;lad@kajf.com");
        ctrl.getDatos().getClientes().addDato(clientVar);
 
        assertEquals("el return no es correcto: ", listaCli.anadirCliente("pepito", "Barcelona", "x78946", "ajf;lad@kajf.com", "1", ctrl.getDatos().getClientes()), "El cliente ha ido añadido: " + clientVar.getNif() +" "+ clientVar.getNombre());
    }


//	@Test
//	void testAnadirClienteEstandar() {
//
//		ctrl = new Controlador();
//		listaCli = new ListaClientes();
//
//		clientVar = new ClienteEstandar("Pepito", "Barcelona", "x78946", "pepito@gmail.com");
//
//		ctrl.getDatos().getClientes().addDato(clientVar);
//
//	
//		assertEquals("el return es correcto: ",
//				listaCli.anadirCliente("Pepito", "Barcelona", "x78946", "pepito@gmail.com", "1",
//						ctrl.getDatos().getClientes()),
//				"El cliente ha ido añadido: " + clientVar.getNif() + " " + clientVar.getNombre());
//	}

	@Test
	void testAnadirClientePremium() {

		ctrl = new Controlador();
		listaCli = new ListaClientes();

		clientVar = new ClientePremium("Marcianito", "Madrid", "0456123", "marcianito@gmail.com");

		ctrl.getDatos().getClientes().addDato(clientVar);
		
		
		assertEquals("el return no es correcto: ",
				listaCli.anadirCliente("Marcianito", "Madrid", "0456123", "marcianito@gmail.com", "2",
						ctrl.getDatos().getClientes()),
				"El cliente ha ido añadido: " + clientVar.getNif() + " " + clientVar.getNombre());
	}

	// if object properties exists in a Client class

	@Test
	void testExisteClienteTrue() {

		ctrl = new Controlador();
		listaCli = new ListaClientes();

		clientVar = new ClienteEstandar("Pepito", "Barcelona", "x78946", "pepito@gmail.com");
		ctrl.getDatos().addCliente(clientVar);

		assertTrue(listaCli.existeCliente("x78946", ctrl.getDatos().getClientes()) == true);

	}

	void testExisteClienteFalse() {

		ctrl = new Controlador();
		listaCli = new ListaClientes();

		clientVar = new ClienteEstandar("Pepito", "Barcelona", "x78946", "pepito@gmail.com");
		ctrl.getDatos().addCliente(clientVar);

		assertTrue(listaCli.existeCliente("x78946", ctrl.getDatos().getClientes()) == false);

	}


	@Test
	void testMostrarClienteEstandar() {
		ctrl = new Controlador();
		listaCli = new ListaClientes();

		clientVar = new ClienteEstandar("test", "Barcelona", "x78946", "pepito@gmail.com");
		ctrl.getDatos().addCliente(clientVar);

		List<Cliente> cli = new ArrayList<>();
		
			for (Cliente cliente : ctrl.getDatos().getClientes().getDato()) {
					cli.add(cliente);
			}

			assertEquals(cli, listaCli.mostrarClienteEstandar(ctrl.getDatos().getClientes()));
			
	}

	  @Test 
	  void testMostrarClientePremium() {
		  
		  ctrl = new Controlador(); 
		  listaCli = new ListaClientes();
		  
		  List<Cliente> cli = new ArrayList<>();
		  
		  clientVar = new ClientePremium("Pepito", "Barcelona", "x78946", "pepito@gmail.com"); 
		  ctrl.getDatos().addCliente(clientVar); //lista generica
		  
	      cli.add(clientVar);
	      
	      assertEquals(cli, listaCli.mostrarClientePremium(ctrl.getDatos().getClientes()));
	      
		}



}
