package tkim.modelo;

public class ClientePremium extends Cliente {

	public ClientePremium(String nif, String nombre, String domicilio, String email,String tipCliente) {
		super(nif, nombre, domicilio, email);
	}

	@Override
	public String tipoCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calcAnual() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public float descuentoEnv() {
		// TODO Auto-generated method stub
		return 0.2f;
	}
	
	



	

}