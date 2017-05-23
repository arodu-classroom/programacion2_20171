package clase_23052017.personas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PersonaController {
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private Persona aux;
	private PersonaViewRead viewRead;
	private PersonaViewForm viewForm;
	int index = -1;
	
	public static void main(String[] args) {
		new PersonaController();
	}

	public PersonaController(){
		this.ver();
	}
	
	public void ver(){
		viewRead = new PersonaViewRead(this);
		viewRead.display();
		if(this.index >= 0){
			viewRead.changeData(this.index, personas.get(this.index));
		}
	}
	
	public void nuevo(){
		viewForm = new PersonaViewForm(this, true);
		viewForm.display(viewRead);
	}
	
	public void guardarNuevo(String nombres, String apellidos, String cedula, String telefono){
		aux = new Persona();
		aux.setNombres(nombres);
		aux.setApellidos(apellidos);
		aux.setCedula(cedula);
		aux.setTelefono(telefono);
		this.index = personas.size();
		personas.add(aux);
		viewRead.changeData(this.index, personas.get(this.index));
	}
	
	public void	siguiente(){
		if(this.index+1 >= personas.size()){
			JOptionPane.showMessageDialog(viewRead, "Fuera de Rango");
		}else{
			this.index++;
			viewRead.changeData(this.index, personas.get(this.index));
		}
	}
	
	public void	anterior(){
		if(this.index-1 < 0){
			JOptionPane.showMessageDialog(viewRead, "Fuera de Rango");
		}else{
			this.index--;
			viewRead.changeData(this.index, personas.get(this.index));
		}
	}
	
	public void editar(int i) {
		viewForm = new PersonaViewForm(this, false);
		viewForm.display(viewRead);
		viewForm.changeData(i ,personas.get(i));
	}
	
	public void guardarEditar(int index, String nombres, String apellidos, String cedula, String telefono){
		aux = new Persona();
		aux.setNombres(nombres);
		aux.setApellidos(apellidos);
		aux.setCedula(cedula);
		aux.setTelefono(telefono);
		personas.add(index, aux);
		viewRead.changeData(this.index, personas.get(this.index));
	}
	
	public void borrar(int i){
		int o = JOptionPane.showConfirmDialog(viewRead, "¿Esta seguro de eliminar el elemento "+i+"?");
		if(o == 0){
			personas.remove(i);
			if(this.index>=personas.size()){
				this.index--;
			}
			viewRead.changeData(this.index, personas.get(this.index));
		}
	}
}
