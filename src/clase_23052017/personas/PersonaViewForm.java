package clase_23052017.personas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonaViewForm extends JFrame implements ActionListener{
	PersonaController controller;
	
	JPanel panel;
	JButton btnAceptar;
	JLabel lblNombres, lblApellidos, lblCedula, lblTelf, lblIndex, vIndex;
	JTextField txtNombres, txtApellidos, txtCedula, txtTelf;
	boolean nuevo = true;
	
	public PersonaViewForm(PersonaController controller, boolean nuevo) {
		this.controller = controller;
		this.nuevo = nuevo;
	}
	
	public void display(JFrame parent){
		this.setLayout(new BorderLayout());
		
		// ------------------------
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		panel.add(btnAceptar);
		
		this.add(panel, BorderLayout.SOUTH);
		// ------------------------
		panel = new JPanel(new GridLayout(5,2));
		
		lblIndex = new JLabel("Numero");
		panel.add(lblIndex);
		
		vIndex = new JLabel("<Nuevo>");
		panel.add(vIndex);
		
		lblNombres = new JLabel("Nombres");
		panel.add(lblNombres);
		
		txtNombres = new JTextField(20);
		panel.add(txtNombres);

		lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField(20);
		panel.add(txtApellidos);
		
		lblCedula = new JLabel("Cedula");
		panel.add(lblCedula);
		
		txtCedula = new JTextField(20);
		panel.add(txtCedula);
		
		lblTelf = new JLabel("Telefono");
		panel.add(lblTelf);
		
		txtTelf = new JTextField(20);
		panel.add(txtTelf);
		
		this.add(panel, BorderLayout.CENTER);
		// ------------------------
		this.pack();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAceptar)){
			String nombres = txtNombres.getText();
			String apellidos = txtApellidos.getText();
			String cedula = txtCedula.getText();
			String telefono = txtTelf.getText();
			if(this.nuevo){
				controller.guardarNuevo(nombres, apellidos, cedula, telefono);
			}else{
				int index = Integer.parseInt(vIndex.getText())-1;
				controller.guardarEditar(index, nombres, apellidos, cedula, telefono);
			}
			this.setVisible(false);
		}
	}
	
	public void changeData(Persona persona){
		txtNombres.setText(persona.getNombres());
		txtApellidos.setText(persona.getApellidos());
		txtCedula.setText(persona.getCedula());
		txtTelf.setText(persona.getTelefono());
	}
	
	public void changeData(int index, Persona persona){
		vIndex.setText(Integer.toString(index+1));
		this.changeData(persona);
	}
	
}
