package tkim.modelo;


public class Datos {
	
	private Listas<Cliente> clientes;
	private Listas<Articulo> articulos;
	private Listas<Pedido> pedidos;

	/**
	 * @param clientes
	 * @param articulos
	 * @param pedidos
	 */
	public Datos() {
		super();
		this.clientes =  new Listas<Cliente>();
		this.articulos = new Listas<Articulo>();
		this.pedidos = new Listas<Pedido>();
	}
	public Listas<Cliente> getClientes() {
		return clientes;
	}
	public void addCliente(Cliente cliente) {
		this.clientes.addDato(cliente);
	}
	public Listas<Articulo> getArticulos() {
		return articulos;
	}
	public void addArticulo(Articulo articulo) {
		articulos.addDato(articulo);
	}
	public Listas<Pedido> getPedidos() {
		return pedidos;
	}
	public void addPedido(Pedido pedido) {
		pedidos.addDato(pedido);
	}
		
}
