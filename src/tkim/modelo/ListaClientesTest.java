package tkim.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import tkim.controlador.Controlador;

class ListaClientesTest {
	
	ListaClientes listaCli;
	Cliente clientVar;
	Controlador ctrl;
	List<Cliente> listaT;
	
	


	@Test
    void testAnadirClienteEstandar() {
		
        ctrl = new Controlador();
        listaCli = new ListaClientes();
        
        
        clientVar = new ClienteEstandar("Pepito", "Barcelona", "x78946", "pepito@gmail.com");
        ctrl.getDatos().getClientes().addDato(clientVar);

        assertEquals("el return es correcto: ", listaCli.anadirCliente("Pepito", "Barcelona", "x78946", "pepito@gmail.com", "1", ctrl.getDatos().getClientes()), "El cliente ha ido añadido: " + clientVar.getNif() +" "+ clientVar.getNombre());
    }
	
	@Test
    void testAnadirClientePremium() {
		
        ctrl = new Controlador();
        listaCli = new ListaClientes();
        
        
        clientVar = new ClientePremium("Marcianito", "Madrid", "0456123", "marcianito@gmail.com");
        ctrl.getDatos().getClientes().addDato(clientVar);

        assertEquals("el return no es correcto: ", listaCli.anadirCliente("Marcianito", "Madrid", "0456123", "marcianito@gmail.com", "2", ctrl.getDatos().getClientes()), "El cliente ha ido añadido: " + clientVar.getNif() +" "+ clientVar.getNombre());
  
    }
		
	
	  //if object properties exists in a Client class
	  
	  @Test 
	  void testExisteClienteTrue() {
	  
	  ctrl = new Controlador(); 
	  listaCli = new ListaClientes();

//	  listaT = Arrays.asList( 
//			  new ClienteEstandar("Pepito", "Malaga", "078913v","pedro@gmai.com"),
//	  
//			  new ClientePremium("Pepito", "Malaga", "024440m", "pedro@gmai.com"));
//	  
//	  String nif = clientVar.getNif();
//	  assertEquals(nif, null, null);
//	  asserEquals(true,)
//	  
	  
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
	  
//	  @Test void testMostrarClienteEstandar() {
//		  fail("Not yet implemented"); 
//	  }
//	  
//	  @Test void testMostrarClientePremium() {
//		  fail("Not yet implemented"); 
//		  }
//	 

}
