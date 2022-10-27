package tkim.modelo;

public class ClienteEstandar extends Cliente{

	public ClienteEstandar(String nif, String nombre, String domicilio, String email, String tipoCliente) {
		super(nif, nombre, domicilio, email);
		
	}

	@Override
	public String tipoCliente() {
		return "Cliente_Estandar";
	}

	@Override
	public float calcAnual() {
		return 0;
	}

	@Override
	public float descuentoEnv() {
		return 0;
	}

	
	



}
