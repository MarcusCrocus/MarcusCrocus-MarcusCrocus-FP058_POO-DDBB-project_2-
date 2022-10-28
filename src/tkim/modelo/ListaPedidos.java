package tkim.modelo;

import java.time.Duration;
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
	      String resultado = "El pedido no ha podido ser eliminado porque ya se ha enviado";
	        for (Pedido pedido : p.getDato()) {
	            if (codigoPedido == pedido.getNumeroPedido()){

	                Duration duration = Duration.between(pedido.getFechaHoraPedido(), LocalDateTime.now());
	                long diff =  Math.abs(duration.toMinutes());
	                boolean enviado_pendiente = pedido.getArticulos().getTiempoPreparacion() > diff;

	                if (enviado_pendiente){
	                    p.getDato().remove(pedido);
	                    resultado = "El pedido ha sido eliminado";
	                }
	            }
	        }
	        return resultado;

	}
	
	
    public ArrayList<Pedido> mostrarPedEnviados(String nif, Listas<Pedido> lped){
        ArrayList<Pedido> pedidosEnviados = new ArrayList<>();
        for (Pedido pd : lped.getDato()) {
            if (nif.equals(pd.getCliente().getNif())){

                Duration duration = Duration.between(pd.getFechaHoraPedido(), LocalDateTime.now());
                long diff =  Math.abs(duration.toMinutes());

                if (pd.getArticulos().getTiempoPreparacion() < diff){
                    pedidosEnviados.add(pd);
                }

            }

        }
        return pedidosEnviados;
    }
}
