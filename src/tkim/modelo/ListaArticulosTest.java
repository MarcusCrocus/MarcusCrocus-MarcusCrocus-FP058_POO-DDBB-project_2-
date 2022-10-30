package tkim.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tkim.controlador.*;

class ListaArticulosTest {
	Controlador c;
	ListaArticulos la;
	Articulo articulo;

	@Test
	void testAddArticulo() {
		la = new ListaArticulos();
		c = new Controlador();
		articulo = new Articulo("a4", "aa", 35.15f, 4.95f, 7200);
		c.getDatos().getArticulos().addDato(articulo);
		assertEquals("el return no es correcto: ", la.addArticulo("a4", "aa", 4.4f, 5.5f, 100, c.getDatos().getArticulos()), "El articulo ha sido añadido correctamente: "+ articulo.getDescripcion());
	}

	@Test
	void testExisteArticuloTrue() {
		la = new ListaArticulos();
		c = new Controlador();
		articulo = new Articulo("a3", "armario", 35.15f, 4.95f, 7200);
		c.getDatos().getArticulos().addDato(articulo);
		assertTrue(la.existeArticulo("a3", c.getDatos().getArticulos()) == true);

	}
	
	@Test
	void testExisteArticuloFalse() {
		la = new ListaArticulos();
		c = new Controlador();
		articulo = new Articulo("a3", "armario", 35.15f, 4.95f, 7200);
		c.getDatos().getArticulos().addDato(articulo);
		assertTrue(la.existeArticulo("a4", c.getDatos().getArticulos()) == false);

	}

}
