package administracion;

public class Cita {
	
	private int ID;
	private String Fecha;
	private float Hora;
	private String Motivo;
	
	public Cita() {}
	
	public Cita(int ID, String Fecha, float Hora, String Motivo) {
		this.ID = ID;
		this.Fecha = Fecha;
		this.Hora = Hora;
		this.Motivo = Motivo;
	}
	public int getID() {
		return ID;
	}
	public String getFecha() {
		return Fecha;
	}
	public float getHora() {
		return Hora;
	}
	public String geMotivo() {
		return Motivo;
	}

}


