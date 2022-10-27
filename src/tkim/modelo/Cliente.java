package tkim.modelo;

public abstract class Cliente {
	
	private String nif;
	private String nombre;
	private String domicilio;
	private String email;
	
	
	//Methods
	
			public abstract String tipoCliente();
			public abstract float calcAnual();
			public abstract float descuentoEnv();
			
	/**
	 * @param nif
	 * @param nombre
	 * @param domicilio
	 * @param email
	 */
	public Cliente(String nif, String nombre, String domicilio, String email) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.email = email;
	}
	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}
	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", nombre=" + nombre + ", domicilio=" + domicilio + ", email=" + email
				+ ", tipoCliente()=" + tipoCliente() + ", calcAnual()=" + calcAnual() + ", descuentoEnv()="
				+ descuentoEnv() + ", getNif()=" + getNif() + ", getNombre()=" + getNombre() + ", getDomicilio()="
				+ getDomicilio() + ", getEmail()=" + getEmail() + "]";
	}

	

	
		

		

		

	
}


