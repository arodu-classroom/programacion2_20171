package clase_27042017;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Suma extends JFrame implements ActionListener{
	
	JButton btnProcesar = new JButton("Procesar");
	JLabel lblUno = new JLabel("Numero A:");
	JTextField txtUno = new JTextField(20);
	JLabel lblDos = new JLabel("Numero 	B:");
	JTextField txtDos = new JTextField(20);
	JLabel lblTres = new JLabel("Resultado:");
	JLabel lblResultado = new JLabel();
	JPanel panel = new JPanel();
	
	public Suma(){
		this.setSize(210,180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Suma");
		
		panel.setLayout(null);
		
		lblUno.setBounds(10, 10, 90, 20);
		txtUno.setBounds(100, 10, 100, 20);
		panel.add(lblUno);
		panel.add(txtUno);
		
		lblDos.setBounds(10, 40, 90, 20);
		txtDos.setBounds(100, 40, 100, 20);
		panel.add(lblDos);
		panel.add(txtDos);
		
		lblTres.setBounds(10, 70, 90, 20);
		lblResultado.setBounds(100, 70, 100, 20);
		panel.add(lblTres);
		panel.add(lblResultado);
		
		btnProcesar.setBounds(10, 120, 190, 20);
		btnProcesar.addActionListener(this);
		panel.add(btnProcesar);
		
		this.add(panel);
		
		this.setVisible(true);  
      }

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(btnProcesar)){
			try{
				int a = Integer.parseInt(txtUno.getText());
				int b = Integer.parseInt(txtDos.getText());
				int c = a + b;
				
				lblResultado.setText( Integer.toString(c) );
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "Numero no válido", "Error", JOptionPane.ERROR_MESSAGE);
				txtUno.setText(null);
				txtDos.setText(null);
				lblResultado.setText(null);
			}
		}
	}

	public static void main(String[] args) {
		new Suma();
	}
	
}
