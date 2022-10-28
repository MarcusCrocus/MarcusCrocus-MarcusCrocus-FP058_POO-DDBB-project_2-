package tkim.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class ListaPedidos {

	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente, Articulo articulo, Listas<Pedido> p) {
		String mensaje = "";
		try {
			
			Pedido pedido = new Pedido(numeroPedido, unidadesPedido, fechaHoraPedido, cliente, articulo);
			p.addDato(pedido);
			mensaje = "El pedido se ha insertado correctamente";
		} catch (NullPointerException e) {
			mensaje = "la clase no existe. Vuelve a intentarlo";
		}
		catch (ArithmeticException e) {
			mensaje = "la clase no existe. Vuelve a intentarlo";
		}
		
		return mensaje;
	}
	
	public ArrayList<Pedido> pedidosCliente(String nifCliente, Listas<Pedido> p){
		ArrayList<Pedido> pedidoXcliente = new ArrayList<>();
		for (Pedido pedido : p.getDato()) {
			if (pedido.getCliente().getNif().equals(nifCliente)) {
					
			}	
		}
		return pedidoXcliente;		
	}
	
	public Boolean existePedido(int codigoPedido, Listas<Pedido> p) {
		Boolean existeArticulo = false;
		for (Pedido pedido : p.getDato()) {
			if (pedido.getNumeroPedido() == (codigoPedido)) {
				existeArticulo = true;
			}
		}
		
		return existeArticulo;
	}
	
	public String eliminarPedido(int codigoPedido, Listas<Pedido> p) {
		return "El pedido ha sido eliminado";
	}

}
