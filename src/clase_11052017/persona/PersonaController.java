package clase_11052017.persona;

import javax.swing.JOptionPane;

public class PersonaController {
	private Persona persona;
	private PersonaViewRead viewRead;
	private PersonaViewForm viewForm;
	
	public static void main(String[] args) {
		new PersonaController();
	}

	public PersonaController(){
		persona = new Persona();
		this.ver();
	}
	
	public void ver(){
		viewRead = new PersonaViewRead(this);
		viewRead.display();
		viewRead.changeData(persona);
	}
	
	public void nuevo(){
		viewForm = new PersonaViewForm(this);
		viewForm.display(viewRead);
	}
	
	public void guardar(String nombres, String apellidos, String cedula, String telefono){
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCedula(cedula);
		persona.setTelefono(telefono);
		viewRead.changeData(persona);
	}
	
	public void editar() {
		viewForm = new PersonaViewForm(this);
		viewForm.display(viewRead);
		viewForm.changeData(persona);
	}
	
	public void borrar(){
		int o = JOptionPane.showConfirmDialog(viewRead, "¿Esta seguro de eliminar los datos?");
		if(o == 0){
			persona = new Persona();
			viewRead.changeData(persona);
		}
	}
}
