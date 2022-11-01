package tkim.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListaPedidos {

	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente,
			Articulo articulo, Listas<Pedido> p) {
		String mensaje = "";
		try {
			float totalPedido = unidadesPedido*articulo.getPrecioVenta();
			float gastosEnvio = articulo.getGastosEnvio();
			float descuentoPremium = cliente.descuentoEnv();
			if (cliente.tipoCliente().equals("Cliente Premium")) {
				gastosEnvio -= (descuentoPremium*gastosEnvio)/100;
				totalPedido += gastosEnvio;
			}else {
				totalPedido += gastosEnvio;
			}
			
			Pedido pedido = new Pedido(numeroPedido, unidadesPedido, fechaHoraPedido, totalPedido, cliente, articulo);
			p.addDato(pedido);
			mensaje = "El pedido se ha insertado correctamente";
		} catch (NullPointerException e) {
			mensaje = "la clase no existe. Vuelve a intentarlo";
		} catch (ArithmeticException e) {
			mensaje = "la clase no existe. Vuelve a intentarlo";
		}

		return mensaje;
	}

	public Boolean existePedido(int codigoPedido, Listas<Pedido> p) {
		Boolean existeArticulo = false;
		for (Pedido pedido : p.getDato()) {
			if (pedido.getNumeroPedido() == (codigoPedido)) {
				existeArticulo = true;
			}
			break;
		}
		return existeArticulo;
	}

	public String eliminarPedido(int codigoPedido, Listas<Pedido> p) {
		String resultado = "El pedido no ha podido ser eliminado porque ya se ha enviado";
		for (Pedido pedido : p.getDato()) {
			if (codigoPedido == pedido.getNumeroPedido()) {

				Duration duration = Duration.between(pedido.getFechaHoraPedido(), LocalDateTime.now());
				long diff = Math.abs(duration.toMinutes());
				boolean enviado_pendiente = pedido.getArticulo().getTiempoPreparacion() > diff;

				if (enviado_pendiente) {
					p.getDato().remove(pedido);
					resultado = "El pedido ha sido eliminado";	
				}
				break;
			}
		}
		return resultado;

	}
	

	public List<Pedido> mostrarPedEnviados(String nif, Listas<Pedido> lped) {

		ArrayList<Pedido> pedidosEnviados = new ArrayList<>();
		for (Pedido pd : lped.getDato()) {
			if (nif.equals(pd.getCliente().getNif())) {

				Duration duration = Duration.between(pd.getFechaHoraPedido(), LocalDateTime.now());
				long diff = Math.abs(duration.toMinutes());

				if (pd.getArticulo().getTiempoPreparacion() < diff) {
					pedidosEnviados.add(pd);
				}

			}

		}
		return pedidosEnviados;
	}

	public List<Pedido> mostrarPedPendientes(String nif, Listas<Pedido> lped) {

		ArrayList<Pedido> pedidosPendientes = new ArrayList<>();
		for (Pedido pd : lped.getDato()) {
			if (nif.equals(pd.getCliente().getNif())) {

				Duration duration = Duration.between(pd.getFechaHoraPedido(), LocalDateTime.now());
				long diff = Math.abs(duration.toMinutes());

				if (pd.getArticulo().getTiempoPreparacion() > diff) {
					pedidosPendientes.add(pd);
				}

			}

		}
		return pedidosPendientes;
	}
}
