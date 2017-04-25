package cartas;

import java.util.Random;

public class Mazo {
	Carta[] mazo;
	int cant;
	
	public Mazo() {
		cant = 40;
		mazo = new Carta[40];
		
		int nums[] = {1,2,3,4,5,6,7,10,11,12};
		String pintas[] = {"B","E","C","O"};
		
		int h = 0;
		for (int i = 0; i < pintas.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				mazo[h] = new Carta(nums[j], pintas[i]);
				h++;
			}
		}	
	}
	
	public void barajar() {
		Random r = new Random();
		Carta aux = new Carta();
		
		for (int i = 0; i < mazo.length; i++) {
			int d = r.nextInt(mazo.length);
			aux = mazo[i];
			mazo[i] = mazo[d];
			mazo[d] = aux;
		}
	}
	
	
	public void mostrar() {
		for (Carta carta : mazo) {
			System.out.println(carta);
		}
	}
	
	public Carta repartir(){
		Carta carta = mazo[cant-1];
		cant--; // cant = cant - 1;
		return carta;
	}
	
}
