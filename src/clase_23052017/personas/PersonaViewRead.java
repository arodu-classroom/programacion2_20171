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

public class PersonaViewRead extends JFrame implements ActionListener {
	JPanel panel;
	JButton btnNuevo, btnEditar, btnBorrar, btnCancelar, btnAnt, btnSig;
	JLabel lblNombres, lblApellidos, lblCedula, lblTelf, lblIndex;
	JLabel vNombres, vApellidos, vCedula, vTelf, vIndex;
	PersonaController controller;
	
	public PersonaViewRead(PersonaController controller) {
		this.controller = controller;
	}
	
	public void display(){
		this.setLayout(new BorderLayout());
		
		// ------------------------
		panel = new JPanel(new FlowLayout());
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);

		
		panel.add(btnNuevo);
		panel.add(btnEditar);
		panel.add(btnBorrar);
		
		this.add(panel, BorderLayout.NORTH);
		
		// ------------------------
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		btnAnt = new JButton("<");
		btnAnt.addActionListener(this);
		panel.add(btnAnt);
		
		btnSig = new JButton(">");
		btnSig.addActionListener(this);
		panel.add(btnSig);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		this.add(panel, BorderLayout.SOUTH);
		// ------------------------
		panel = new JPanel(new GridLayout(5,2));
		
		lblIndex = new JLabel("Numero");
		panel.add(lblIndex);
		
		vIndex = new JLabel("------");
		panel.add(vIndex);
		
		lblNombres = new JLabel("Nombres");
		panel.add(lblNombres);
		
		vNombres = new JLabel("------");
		panel.add(vNombres);

		lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos);
		
		vApellidos = new JLabel("------");
		panel.add(vApellidos);
		
		lblCedula = new JLabel("Cedula");
		panel.add(lblCedula);
		
		vCedula = new JLabel("------");
		panel.add(vCedula);
		
		lblTelf = new JLabel("Telefono");
		panel.add(lblTelf);
		
		vTelf = new JLabel("------");
		panel.add(vTelf);
		
		this.add(panel, BorderLayout.CENTER);
		// ------------------------
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void changeData(int index, Persona persona){
		vIndex.setText(Integer.toString(index+1));
		vNombres.setText(persona.getNombres());
		vApellidos.setText(persona.getApellidos());
		vCedula.setText(persona.getCedula());
		vTelf.setText(persona.getTelefono());
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.btnCancelar)){
			System.exit(0);
		}
		
		if(e.getSource().equals(this.btnNuevo)){
			controller.nuevo();
		}
		
		if(e.getSource().equals(this.btnSig)){
			controller.siguiente();
		}
		 	
		if(e.getSource().equals(this.btnAnt)){
			controller.anterior();
		}
		
		if(e.getSource().equals(this.btnEditar)){
			controller.editar(Integer.parseInt(vIndex.getText())-1);
		}
		
		if(e.getSource().equals(this.btnBorrar)){
			controller.borrar(Integer.parseInt(vIndex.getText())-1);
		}
	}
	
}
