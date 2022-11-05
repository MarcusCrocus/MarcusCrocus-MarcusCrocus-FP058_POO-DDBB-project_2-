package tkim.dao;


import java.util.List;
import tkim.modelo.Articulo;

public interface IArticuloDAO {
	
	public String addArticulos(Articulo articulo);
	public List<Articulo> mostrarArticulos();
	public Boolean existeArticulo(String codigo);

}
