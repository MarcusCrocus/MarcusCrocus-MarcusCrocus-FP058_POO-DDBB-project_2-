package tkim.controlador;

import java.time.LocalDateTime;
import java.util.List;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;
import tkim.modelo.LanzarArticuloDAO;
import tkim.modelo.LanzarClienteDAO;
import tkim.modelo.LanzarPedidoDAO;
import tkim.modelo.Pedido;

public class Controlador {
	LanzarPedidoDAO lpd = new LanzarPedidoDAO();
	LanzarClienteDAO lcd = new LanzarClienteDAO();
	LanzarArticuloDAO lad = new LanzarArticuloDAO();
	
	public String addCliente(String nif, String nombre, String domi, String mail, String tipoCliente) {
		try {
			return lcd.anadirClientes(nif, nombre, domi, mail, tipoCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, String nif, String codigo_articulo) {
		try {
			Cliente c = lcd.buscarCliente(nif);
			Articulo a = lad.buscarArticulo(codigo_articulo);
			return lpd.addPedido(numeroPedido, unidadesPedido, fechaHoraPedido, c, a);
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
	
	public List<Cliente> mostrarClientesTodos(){
		return lcd.mostrarClientesTodos();	
	}
	
	public List<Cliente> mostrarClientesXtipo(String tipoCliente){
		return lcd.mostrarClientesXtipo(tipoCliente);	
	}
	
	public Boolean existeArticulo(String codigo) {
		return lad.existeArticulo(codigo);
		
	}
	
	public Boolean existeCliente(String nif) {
		return lcd.existeCliente(nif);
		
	}
	
	public Boolean existePedido(int codigoPedido) {
		return lpd.existePedido(codigoPedido);
		
	}
	
	public String eliminarPedido(int codigoPedido) {
		return lpd.eliminarPedido(codigoPedido);
	}
	
	public List<Pedido> mostrarPedEnviados(int numeroOrdenArray) {
		//String nif = datos.getClientes().getDato().get(numeroOrdenArray-1).getNif();
		//return lpd.mostrarPedEnviados(nif);
		return null;
	}
	
	public List<Pedido> mostrarPedPendientes(int numeroOrdenArray) {
		//String nif = datos.getClientes().getDato().get(numeroOrdenArray-1).getNif();
		//return lpd.mostrarPedPendientes(nif);
		return null;
	}

	public LanzarPedidoDAO getLpd() {
		return lpd;
	}

	public void setLpd(LanzarPedidoDAO lpd) {
		this.lpd = lpd;
	}

	public LanzarClienteDAO getLcd() {
		return lcd;
	}

	public void setLcd(LanzarClienteDAO lcd) {
		this.lcd = lcd;
	}

	public LanzarArticuloDAO getLad() {
		return lad;
	}

	public void setLad(LanzarArticuloDAO lad) {
		this.lad = lad;
	}
}
