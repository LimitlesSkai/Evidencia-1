package administracion;

public class Persona {

	private String Nombre;
	private int ID;
	
	public Persona() {}
	
	public Persona(String Nombre, int ID) {
		this.Nombre = Nombre;
		this.ID = ID;
	}
	public String getNombre() {
		return Nombre;
	}
	public int getID() {
		return ID;
	}
}
