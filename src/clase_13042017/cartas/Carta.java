package clase_13042017.cartas;

public class Carta {
	int num;
	String pinta;
	
	public Carta() {
	}
	
	public Carta(int num, String pinta) {
		this.num = num;
		this.pinta = pinta;
	}
	
	@Override
	public String toString() {
		String out = "+---+\n"
					+"| "+( this.num >= 10 ? this.num : this.num+" " )+"|\n"
					+"| "+this.pinta+" |\n"
					+"+---+\n";
		return out;
	}
	
	
	
}


//	condicion ? si : no
			
			

