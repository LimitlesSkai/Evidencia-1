package administracion;

public class Doctor extends Persona {
	
	private String Especialidad;
	
	public Doctor() {}
	
	public Doctor(String Nombre, int ID, String Especialidad) {
		this.Especialidad = Especialidad;
	}
	public String getEspecialidad() {
		return Especialidad;
	}
}