package tkim.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import tkim.controlador.Controlador;
//comentario isra
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
	void testExistePedido() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarPedido() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarPedEnviados() {
		fail("Not yet implemented");
	}

	@Test
	void testMostrarPedPendientes() {
		fail("Not yet implemented");
	}

}
