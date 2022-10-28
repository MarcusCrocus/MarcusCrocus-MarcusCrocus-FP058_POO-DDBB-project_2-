package tkim.controlador;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.Datos;
import tkim.modelo.ListaArticulos;
import tkim.modelo.ListaClientes;
import tkim.modelo.ListaPedidos;

public class Controlador {
	
	ListaClientes lc = new ListaClientes();
	ListaArticulos la = new ListaArticulos();
	ListaPedidos lp = new ListaPedidos();
	Datos datos = new Datos();
	
	public String addCliente(String nombre, String domi, String nif, String mail, String tipoCliente) {
		try {
			return lc.anadirCliente(nombre,domi,nif, mail, tipoCliente, datos.getClientes());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "hola";
		
	}
	
	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, String cliente, String art) {
		try {
			Cliente c = datos.getClientes().getDato().get(Integer.parseInt(cliente)-1);
			Articulo a = datos.getArticulos().getDato().get(Integer.parseInt(art) - 1);
			return lp.addPedido(numeroPedido, unidadesPedido, fechaHoraPedido, c, a, datos.getPedidos());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "hola";
		
	}
	
	public String addArticulo(String codigo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion) {
		try {
			return la.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion, datos.getArticulos());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "hola";
		
	}
	
	public List<Cliente> mostrarClientesEstandar(){
		return lc.mostrarClienteEstandar(datos.getClientes());	
	}
	
	public List<Cliente> mostrarClientesPremium(){
		return lc.mostrarClientePremium(datos.getClientes());
		
	}
	
	public Boolean existeArticulo(String codigo) {
		return la.existeArticulo(codigo, datos.getArticulos());
		
	}
	
	public Boolean existeCliente(String nif) {
		return lc.existeCliente(nif, datos.getClientes());
		
	}
	
	public Boolean existePedido(int codigoPedido) {
		return lp.existePedido(codigoPedido, datos.getPedidos());
		
	}
	
	public String eliminarPedido(int codigoPedido) {
		return lp.eliminarPedido(codigoPedido, datos.getPedidos());
	}

	public ListaClientes getLc() {
		return lc;
	}

	public void setLc(ListaClientes lc) {
		this.lc = lc;
	}

	public ListaArticulos getLa() {
		return la;
	}

	public void setLa(ListaArticulos la) {
		this.la = la;
	}

	public ListaPedidos getLp() {
		return lp;
	}

	public void setLp(ListaPedidos lp) {
		this.lp = lp;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	
}
