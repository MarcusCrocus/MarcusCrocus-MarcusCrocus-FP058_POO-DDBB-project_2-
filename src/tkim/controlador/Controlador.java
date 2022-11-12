package tkim.controlador;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.Datos;
import tkim.modelo.LanzarArticuloDAO;
import tkim.modelo.LanzarClienteDAO;
import tkim.modelo.ListaArticulos;
import tkim.modelo.ListaClientes;
import tkim.modelo.ListaPedidos;
import tkim.modelo.Pedido;

public class Controlador {
	ListaPedidos lp = new ListaPedidos();
	LanzarClienteDAO lcd = new LanzarClienteDAO();
	Datos datos = new Datos();
	LanzarArticuloDAO lad = new LanzarArticuloDAO();
	
	public String addCliente(String nombre, String domi, String nif, String mail, String tipoCliente) {
		try {
			return lcd.anadirClientesDAO(nombre,domi,nif, mail, tipoCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		
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
			return lad.addArticulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "hola";
		
	}
	
	public List<Articulo> mostrarArticulos(){
		return lad.mostrarArticulos();
	}
	
	public List<Cliente> mostrarClientes(){
		return lcd.mostrarClientesDAO();	
	}
	
	public Boolean existeArticulo(String codigo) {
		return lad.existeArticulo(codigo);
		
	}
	
	public Boolean existeCliente(String nif) {
		return lcd.existeCliente(nif);
		
	}
	
	public Boolean existePedido(int codigoPedido) {
		return lp.existePedido(codigoPedido, datos.getPedidos());
		
	}
	
	public String eliminarPedido(int codigoPedido) {
		return lp.eliminarPedido(codigoPedido, datos.getPedidos());
	}
	
	public List<Pedido> mostrarPedEnviados(int numeroOrdenArray) {
		String nif = datos.getClientes().getDato().get(numeroOrdenArray-1).getNif();
		return lp.mostrarPedEnviados(nif, datos.getPedidos());
	}
	
	public List<Pedido> mostrarPedPendientes(int numeroOrdenArray) {
		String nif = datos.getClientes().getDato().get(numeroOrdenArray-1).getNif();
		return lp.mostrarPedPendientes(nif, datos.getPedidos());
	}

	public ListaPedidos getLp() {
		return lp;
	}

	public void setLp(ListaPedidos lp) {
		this.lp = lp;
	}

	public LanzarClienteDAO getLcd() {
		return lcd;
	}

	public void setLcd(LanzarClienteDAO lcd) {
		this.lcd = lcd;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public LanzarArticuloDAO getLad() {
		return lad;
	}

	public void setLad(LanzarArticuloDAO lad) {
		this.lad = lad;
	}
	
	
}
