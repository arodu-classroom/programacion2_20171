package clase_04042017;

import java.util.Scanner;

public class Empleado extends Persona {
	String cargo;
	float sueldo;
	int ht;

	@Override
	public void mostrar() {
		super.mostrar();
		String out = "Datos del Empleado"
			+"Cargo: "+cargo+"\n"
			+"Sueldo: "+sueldo+"\n"
			+"Horas Trabajadas: "+ht+"\n"
			+"Pago: "+pago();
		
		System.out.println(out);
	}
	
	@Override
	public void leer() {
		super.leer();
		Scanner e = new Scanner(System.in);
		
		System.out.println("Ingrese Cargo:");
		cargo = e.next();
		System.out.println("Ingrese Sueldo:");
		sueldo = e.nextFloat();
		System.out.println("Ingrese Horas Trabajadas:");
		ht = e.nextInt();
		
		
	}
	
	public float pago(){
		return ht * sueldo;
	}
	
}


