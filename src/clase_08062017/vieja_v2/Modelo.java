package vieja_v2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo {
	private int tablero[] = new int[9];
	private int turno, j1, j2;
	private SQLite sqlite;
	
	public Modelo() {
		sqlite = new SQLite("/home/arodu/vieja.db");
		this.init();
	}
	
	private void getPuntuacion(){
		ResultSet rs = sqlite.select("SELECT * FROM puntuaciones");
		try {
			while(rs.next()){
				if( rs.getInt("jugador") == 1 ){
					j1 = rs.getInt("puntos");
				}
				if( rs.getInt("jugador") == 2 ){
					j2 = rs.getInt("puntos");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setPuntuacion() {
		String sql = "";
		if(turno == 1){
			sql = "UPDATE puntuaciones SET puntos="+(j1+1)+" WHERE jugador=1";
		}else if(turno == 2){
			sql = "UPDATE puntuaciones SET puntos="+(j2+1)+" WHERE jugador=2";
		}
		sqlite.update(sql);
	}
	
	
	public void sumarResultado(){
		setPuntuacion();
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
		getPuntuacion();
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
