

  // arodriguez@unerg.edu.ve


package cartas;

public class Mano {
	Carta[] mano;
	int cant;
	
	public Mano() {
		mano = new Carta[3];
		cant = 0;
	}
	
	public void recibir(Carta carta) {
		mano[cant] = carta;
		cant++;
	}

	public void mostrar(){
		for (Carta carta : mano) {
			System.out.println(carta);
		}
	}
	
	public String canto(){
		/*
		if( mano[0].num==mano[1].num && mano[1].num==mano[2].num ){
			return "...";
		}
		
		if(mano[0].num==1 && mano[1].num==11 && mano[2].num==12){
			return "Registro";
		}
		
		if(mano[0].num==mano[1].num && mano[1].num != mano[2].num ){
			
		}
		
		if(mano[0].num==mano[1].num &&(mano[1].num == mano[2].num-1 || mano[1].num == mano[2].num+1){
			
		}
		*/
		
		
		return "";
	} 
	
	
	
}

