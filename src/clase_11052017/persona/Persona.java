package clase_11052017.persona;

public class Persona {
	private String nombres = null;
	private String apellidos = null;
	private String cedula = null;
	private String telefono = null;
	private String fecha_nacimiento = null;
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	
	public String getNombres() {
		return nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	private int getEdad() {
		return 0;
	}
	
}
