package tkim.modelo;

public class ListaArticulos extends Listas<Articulo>{

	public String addArticulo(String codigo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion, Listas<Articulo> a) {
		
		try {
			Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
			a.addDato(articulo);

			return "El articulo ha sido añadido correctamente: " + articulo.getDescripcion();
		} catch (Exception e) {
			return "El articulo no ha podido introducirse correctamente";
		}
	}
	
	public Boolean existeArticulo(String codigo, Listas<Articulo> a) {
		Boolean existeArticulo = false;
		for (Articulo articulo : a.getDato()) {
			if (articulo.getCodigo().equals(codigo)) {
				existeArticulo = true;
			}
		}
		
		return existeArticulo;
	}
}
