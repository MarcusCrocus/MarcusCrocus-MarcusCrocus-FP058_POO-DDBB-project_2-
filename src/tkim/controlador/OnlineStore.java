package tkim.controlador;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import tkim.modelo.*;


public class OnlineStore {
	

	Scanner input = new Scanner(System.in);
	
	Controlador ctrl = new Controlador();
	
	

//Menu
	
	public static void main(String[] args) {
			
		OnlineStore os = new OnlineStore();
		
		os.cargarDatos();
		os.menu();
		
			
	}		
	
	private void menu() {
		
		boolean exit = false;
		
        char option;
        
    	System.out.println("1. Agregar Cliente");
    	System.out.println("2. Mostrar Cliente Estandar"); 
    	System.out.println("3. Mostrar Cliente Premium"); 
    	System.out.println("4. Mostrar Todos Clientes");      
        
        do {
        	option = askOptions();
        		switch (option) {
        		case '1':
        			dataInput();
        			break;
        		case '2':
        			showClientesEstandar();
        			break;
        		case '3':
        			//showClientesPremium();
        			break;
        		
        		case '4':
        			//showClientes();
        			break;
        		}
        	
        }while (!exit);
    
	}




	//numbers asking function
	char askOptions(){
        String resp;
        input = new Scanner(System.in);
        
        System.out.println("Elije una opccion (1,2)");
        resp = input.nextLine();
	        if (resp.isEmpty()){
	         resp = " ";   
	        }
        return resp.charAt(0);
    }
	
//AddCliente
    
	public void dataInput() {
		
				
		System.out.println("Nif: ");
        String nif = input.nextLine();
        

		
		 if (ctrl.existeCliente(nif)) {
			 System.out.println("Ya existe un cliente con ese NIF"); 
			 return; 
		}
		 
        
        System.out.println("Nombre: ");
        String nombre = input.nextLine();

        System.out.println("Domicilio: ");
        String domicilio = input.nextLine();

        System.out.println("Email: ");
        String email = input.nextLine();

        String tipoCliente;
        
        System.out.println("Escoge el tipo de cliente: (1) Estandar (2) Premium");
		do {
			
			tipoCliente = input.nextLine();
		}while(!"12".contains(tipoCliente));
	
        System.out.println(ctrl.dInput(nif, nombre, domicilio, email,tipoCliente));
	}  
	

//Mostrar Clientes Estandar
	
	private String showClientesEstandar() {
		
		for (Cliente clientes: ctrl.clienteEstandar()) {
			System.out.println(clientes.getNombre());
			
		}
		return null;
		
		
	}
	
	void cargarDatos() {

		
	//Estandar default data Client						
			
			Cliente cliente1 = new ClienteEstandar("x123456","Pepito", "Barcelona", "pepito@gmail.com", "1");
			Cliente cliente2 = new ClienteEstandar("x1789006","Paquito", "Madrid", "paquito@gmail.com", "1");
			Cliente cliente3 = new ClienteEstandar("r456123","Marcianito", "Valencia", "marcianito@gmail.com", "1");
	
	//Premium default data Client			
			
			Cliente cliente4 = new ClientePremium("b456789","Anna", "Zamorra", "anna@gmail.com", "2");
			Cliente cliente5 = new ClientePremium("m421387","Lidia", "Alicante", "lidia@gmail.com", "2");
			Cliente cliente6 = new ClientePremium("x95214566","Ester", "Malaga", "ester@gmail.com", "2");
			
			
			
			ctrl.dt.getClientes().addDato(cliente1);
			ctrl.dt.getClientes().addDato(cliente2);
			ctrl.dt.getClientes().addDato(cliente3);
			ctrl.dt.getClientes().addDato(cliente4);
			ctrl.dt.getClientes().addDato(cliente5);
			ctrl.dt.getClientes().addDato(cliente6);
			

	}

}	
	


