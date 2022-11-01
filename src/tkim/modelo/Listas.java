package tkim.modelo;

import java.util.ArrayList;

public class Listas <T> {

	protected ArrayList <T> datos;
	
		//constructor
	public Listas() {
		datos = new ArrayList<>();
	}
	
	
	
	
	
	public ArrayList<T>getDato(){
		return datos;
	}
	
	public void addDato (T dato) {
		datos.add(dato);
	}





	/*
	 * public ArrayList<T> getDatos() { return datos; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void setDatos(ArrayList<T> datos) { this.datos = datos; }
	 */
		
	

	
	
}
