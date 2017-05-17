package clase_04042017;

import java.util.Scanner;

public class Persona {
	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	
	public void mostrar(){
		String out;
		out = "Datos Personales:\n"
			+ "Nombre: "+nombre +" "+ apellido+"\n"
			+ "Cedula: "+cedula+"\n"
			+ "Edad: "+edad+"\n"
		;
		System.out.println(out);
	}
	
	
	public void leer(){
		Scanner e = new Scanner(System.in);
		
		System.out.println("Ingrese nombre: ");
		nombre = e.next();
		
		System.out.println("Ingrese apellido: ");
		apellido = e.next();
		
		System.out.println("Ingrese cedula: ");
		cedula = e.next();
		
		System.out.println("Ingrese edad: ");
		edad = e.nextInt();
		
	}
	
}
