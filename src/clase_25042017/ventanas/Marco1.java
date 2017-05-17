package clase_25042017.ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Marco1 {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame();
		//ventana.setSize(400, 400)
		ventana.setBounds(100, 100, 400, 400);
		
		ventana.setTitle("Mi Primera Ventana");
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ventana.add(panel);
		panel.setLayout(null);
		
		JLabel texto = new JLabel("Hola Mundo!!!");
		texto.setBounds(50, 50, 100, 20);
		panel.add(texto);
		
		JButton boton = new JButton("Aceptar");
		boton.setBounds(50, 150, 100, 20);
		panel.add(boton);
		
		ventana.setVisible(true);
	}

}
