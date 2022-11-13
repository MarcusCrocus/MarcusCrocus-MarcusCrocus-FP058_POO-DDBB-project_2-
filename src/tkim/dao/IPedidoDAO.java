package tkim.dao;

import java.time.LocalDateTime;

import tkim.modelo.Articulo;
import tkim.modelo.Cliente;

public interface IPedidoDAO {
	
	public Boolean existePedido(Integer codigo);
	
	public String addPedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente,
			Articulo articulo);
	public String eliminarPedido(int numPedido);

}
