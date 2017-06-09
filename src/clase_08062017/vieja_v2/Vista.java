package vieja_v2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Vista extends JFrame implements ActionListener {
	Controlador controlador;
	
	JButton botones[] = new JButton[9];
	JPanel panel;
	JLabel lblTurno, lblResultados;
	
	public Vista(Controlador controlador) {
		this.controlador = controlador;
		this.display();
	}
	
	public void display(){
		this.setLayout(new BorderLayout());
		//-------------
		
		panel = new JPanel(new GridLayout(3,3));
		
		for(int i=0; i < botones.length; i++){
			botones[i] = new JButton(" ");
			panel.add(botones[i]);
			botones[i].addActionListener(this);
		}
		
		this.add(panel, BorderLayout.CENTER);
		//-------------
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		lblTurno = new JLabel("---");
		panel.add(lblTurno);
		this.add(panel, BorderLayout.NORTH);
		
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblResultados = new JLabel("---");
		panel.add(lblResultados);
		this.add(panel, BorderLayout.SOUTH);
		
		//-------------
		this.setSize(200, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Vieja v2.0");
	}
	
	private String simbolo(int turno) {
		if(turno == 1){
			return "X";
		}else if(turno == 2){
			return "O";
		}
		return " ";
	}
	
	public void jugada(int pos, int turno){
		botones[pos].setText(simbolo(turno));
	}
	
	public void verTurno(int turno){
		lblTurno.setText("Turno "+turno+" [ "+simbolo(turno)+" ]");
	}
	
	public void verResultados(int j1, int j2){
		String o = "Jugador 1: "+j1+"    Jugador 2: "+j2;
		lblResultados.setText(o);
	}
	
	public void ganador(int turno) {
		if(turno > 0){
			int o = JOptionPane.showConfirmDialog(this, "Ganador jugador "+turno+"\n¿Desea jugar otra vez?");
			if(o == 0){
				controlador.reset();
			}else{
				System.exit(0);
			}
		}else{
			int o = JOptionPane.showConfirmDialog(this, "No hay ganador\n¿Desea jugar otra vez?");
			if(o == 0){
				controlador.reset();
			}else{
				System.exit(0);
			}
		}
	}
	
	public void clean(){
		for(int i=0; i<botones.length; i++){
			botones[i].setText(simbolo(0));
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		for(int i=0; i<botones.length; i++){
			if(arg0.getSource().equals(botones[i])){
				controlador.jugada(i);
			}
		}
	}
}
