package tkim.modelo;

public class Articulo {

	private String codigo;
	private String descripcion;
	private float precioVenta;
	private float gastosEnvio;
	private int tiempoPreparacion;
	/**
	 * @param codigo
	 * @param descripcion
	 * @param precioVenta
	 * @param gastosEnvio
	 * @param tiempoPreparacion
	 */
	public Articulo(String codigo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioVenta = precioVenta;
		this.gastosEnvio = gastosEnvio;
		this.tiempoPreparacion = tiempoPreparacion;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the precioVenta
	 */
	public float getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	/**
	 * @return the gastosEnvio
	 */
	public float getGastosEnvio() {
		return gastosEnvio;
	}
	/**
	 * @param gastosEnvio the gastosEnvio to set
	 */
	public void setGastosEnvio(float gastosEnvio) {
		this.gastosEnvio = gastosEnvio;
	}
	/**
	 * @return the tiempoPreparacion
	 */
	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}
	/**
	 * @param tiempoPreparacion the tiempoPreparacion to set
	 */
	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", descripcion=" + descripcion + ", precioVenta=" + precioVenta
				+ ", gastosEnvio=" + gastosEnvio + ", tiempoPreparacion=" + tiempoPreparacion + ", getCodigo()="
				+ getCodigo() + ", getDescripcion()=" + getDescripcion() + ", getPrecioVenta()=" + getPrecioVenta()
				+ ", getGastosEnvio()=" + getGastosEnvio() + ", getTiempoPreparacion()=" + getTiempoPreparacion()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}


