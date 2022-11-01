package tkim.modelo;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import tkim.controlador.Controlador;



class ListaPedidosTest {
    Controlador c;
    ListaPedidos lp;
    Pedido pedido;
    Cliente cliente;
    Articulo articulo;
    
    @Test
    void testAddPedido() {
        c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now(), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
        assertEquals("el return no es correcto: ", lp.addPedido(1, 1, LocalDateTime.now(), cliente, articulo, c.getDatos().getPedidos()), "El pedido se ha insertado correctamente");
    }



	@Test
	void testPedidosCliente() {
		c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now(), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
        
        
        List<Pedido> ped = new ArrayList<>();
        
        for (Pedido pedido : c.getDatos().getPedidos().getDato() ) {
        	ped.add(pedido);
        }
        
        assertEquals(ped, lp.mostrarPedPendientes(cliente.getNif(),c.getDatos().getPedidos()));
		
	}

	@Test
	void testExistePedido() {
		c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now(), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
        assertTrue(lp.existePedido(123, c.getDatos().getPedidos()) == true);
		
	
	}

	@Test
	void testEliminarPedido() {
		c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now(), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
       
       
	}

	@Test
	void testMostrarPedEnviados() {
		c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now().plusDays(-1), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
        
        List<Pedido> pedEnviado = new ArrayList<>();
        
        for (Pedido pedido : c.getDatos().getPedidos().getDato() ) {
        	pedEnviado.add(pedido);
        }
       
        assertEquals(pedEnviado, lp.mostrarPedEnviados(cliente.getNif(),c.getDatos().getPedidos()));
		
		
	
	}
	

	@Test
	void testMostrarPedPendientes() {
		c = new Controlador();
        lp = new ListaPedidos();
        cliente = new ClienteEstandar("yo", "mio", "sdfas", "sd");
        articulo = new Articulo("a", "a", 12.12f, 12.10f, 1);
        pedido = new Pedido(123, 1, LocalDateTime.now().plusDays(-1), 10.20f, cliente, articulo);
        c.getDatos().getPedidos().addDato(pedido);
        
        List<Pedido> pedpendiente = new ArrayList<>();
        
        for (Pedido pedido : c.getDatos().getPedidos().getDato() ) {
        	pedpendiente.add(pedido);
        }
       
        assertEquals(pedpendiente, lp.mostrarPedPendientes(cliente.getNif(),c.getDatos().getPedidos()));
		
	}

}

