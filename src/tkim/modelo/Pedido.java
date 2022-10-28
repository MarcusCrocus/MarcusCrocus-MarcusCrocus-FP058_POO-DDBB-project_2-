package tkim.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import tkim.modelo.Cliente;
import tkim.modelo.Articulo;

public class Pedido {
	
	private int numeroPedido;
	private int unidadesPedido;
	private LocalDateTime fechaHoraPedido;
	private float totalPedido;
	
	
	private Cliente cliente;
	private Articulo articulo;
	/**
	 * @param numeroPedido
	 * @param unidadesPedido
	 * @param fechaHoraPedido
	 * @param cliente
	 * @param articulo
	 */
	public Pedido(int numeroPedido, int unidadesPedido, LocalDateTime fechaHoraPedido, Cliente cliente,
			Articulo articulo) {
		this.numeroPedido = numeroPedido;
		this.unidadesPedido = unidadesPedido;
		this.fechaHoraPedido = fechaHoraPedido;
		this.cliente = cliente;
		this.articulo = articulo;
	}
	/**
	 * @return the numeroPedido
	 */
	public int getNumeroPedido() {
		return numeroPedido;
	}
	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	/**
	 * @return the unidadesPedido
	 */
	public int getUnidadesPedido() {
		return unidadesPedido;
	}
	/**
	 * @param unidadesPedido the unidadesPedido to set
	 */
	public void setUnidadesPedido(int unidadesPedido) {
		this.unidadesPedido = unidadesPedido;
	}
	/**
	 * @return the fechaHoraPedido
	 */
	public LocalDateTime getFechaHoraPedido() {
		return fechaHoraPedido;
	}
	/**
	 * @param fechaHoraPedido the fechaHoraPedido to set
	 */
	public void setFechaHoraPedido(LocalDateTime fechaHoraPedido) {
		this.fechaHoraPedido = fechaHoraPedido;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the articulo
	 */
	public Articulo getArticulos() {
		return articulo;
	}
	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulos(Articulo articulo) {
		this.articulo = articulo;
	}
	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", unidadesPedido=" + unidadesPedido + ", fechaHoraPedido="
				+ fechaHoraPedido + ", cliente=" + cliente + ", articulo=" + articulo + ", getNumeroPedido()="
				+ getNumeroPedido() + ", getUnidadesPedido()=" + getUnidadesPedido() + ", getFechaHoraPedido()="
				+ getFechaHoraPedido() + ", getCliente()=" + getCliente() + ", getArticulos()=" + getArticulos()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
