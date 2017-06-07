package vieja;

public class Controlador {
	Modelo modelo;
	Vista vista;
	
	public static void main(String[] args) {
		new Controlador();
	}

	public Controlador() {
		vista = new Vista(this);
		modelo = new Modelo();
		vista.verTurno(modelo.getTurno());
		vista.verResultados(modelo.getJ1(), modelo.getJ2());
	}
	
	public void reset(){
		modelo.init();
		vista.clean();
		vista.verTurno(modelo.getTurno());
		vista.verResultados(modelo.getJ1(), modelo.getJ2());
	}
	
	public void jugada(int pos) {
		if(modelo.jugada(pos)){
			vista.jugada(pos, modelo.getTurno());
			if(modelo.esGanador()){
				modelo.sumarResultado();
				vista.ganador(modelo.getTurno());
			}else if(modelo.estaLleno()){
				vista.ganador(0);
			}else{
				modelo.cambioTurno();
				vista.verTurno(modelo.getTurno());
			}
		}
	}
	
	
	
}
