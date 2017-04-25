package cartas;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();

		mazo.barajar();
		//mazo.mostrar();
		
		Mano jugador1 = new Mano();
		Mano jugador2 = new Mano();
		
		jugador1.recibir(mazo.repartir());
		jugador2.recibir(mazo.repartir());
		jugador1.recibir(mazo.repartir());
		jugador2.recibir(mazo.repartir());
		jugador1.recibir(mazo.repartir());
		jugador2.recibir(mazo.repartir());
		
		System.out.println("Jugador 1");
		jugador1.mostrar();
		jugador1.canto();
		
		System.out.println("Jugador 2");
		jugador2.mostrar();
		jugador2.canto();
		
	}
	

}
