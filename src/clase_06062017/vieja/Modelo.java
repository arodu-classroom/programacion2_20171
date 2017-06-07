package vieja;

public class Modelo {
	private int tablero[] = new int[9];
	private int turno, j1, j2;
	
	public Modelo() {
		this.init();
		this.j1 = 0;
		this.j2 = 0;
	}
	
	public void sumarResultado(){
		if(turno == 1){
			j1++;
		}else if(turno == 2){
			j2++;
		}
	}
	
	public int getJ1() {
		return j1;
	}
	
	public int getJ2() {
		return j2;
	}
	
	public void init(){
		this.turno = 1;
		for(int i=0; i<tablero.length; i++){
			tablero[i] = 0;
		}
	}
	
	public void cambioTurno(){
		if(this.turno == 1){
			this.turno = 2;
		}else{
			this.turno = 1;
		}
	}
	
	public int getTurno() {
		return turno;
	}
	
	public boolean jugada(int pos){
		if(tablero[pos] > 0){
			return false;
		}else{
			tablero[pos] = this.turno;
			return true;
		}
	}
	
	public boolean estaLleno(){
		boolean lleno = true;
		for(int i=0; i<tablero.length; i++){
			if(tablero[i] == 0){
				lleno = false;
			}
		}
		return lleno;
	}
	
	public boolean esGanador(){
		
		if(tablero[0] == tablero[1] && tablero[1] == tablero[2] && tablero[0] != 0){
			return true;
		}
		if(tablero[3] == tablero[4] && tablero[4] == tablero[5] && tablero[3] != 0){
			return true;
		}
		if(tablero[6] == tablero[7] && tablero[7] == tablero[8] && tablero[6] != 0){
			return true;
		}
		
		if(tablero[0] == tablero[3] && tablero[3] == tablero[6] && tablero[0] != 0){
			return true;
		}
		if(tablero[1] == tablero[4] && tablero[4] == tablero[7] && tablero[1] != 0){
			return true;
		}
		if(tablero[2] == tablero[5] && tablero[5] == tablero[8] && tablero[2] != 0){
			return true;
		}
		
		if(tablero[0] == tablero[4] && tablero[4] == tablero[8] && tablero[0] != 0){
			return true;
		}
		if(tablero[2] == tablero[4] && tablero[4] == tablero[6] && tablero[2] != 0){
			return true;
		}
		return false;
	}

}
