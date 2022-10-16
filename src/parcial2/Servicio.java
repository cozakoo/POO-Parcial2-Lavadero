package parcial2;

public class Servicio {
	
	private String descripcion;
	private double costo;
	
	public Servicio(String descripcion, double costo) {
		this.descripcion = descripcion;
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}
	
}
