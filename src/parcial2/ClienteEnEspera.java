package parcial2;

import java.util.ArrayList;

public class ClienteEnEspera {
	
	private Vehiculo vehiculo;
	private Persona conductor;
	private String horaLLegada;
	private ArrayList<Servicio> serviciosRequeridos; 
	
	public ClienteEnEspera(Vehiculo vehiculo, Persona conductor, String horaLlegada, ArrayList<Servicio> serviciosRequeridos) {
		super();
		this.vehiculo = vehiculo;
		this.conductor = conductor;
		this.serviciosRequeridos = serviciosRequeridos;
		this.horaLLegada = horaLlegada; 
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public Persona getConductor() {
		return conductor;
	}

	public ArrayList<Servicio> getServiciosRequeridos() {
		return serviciosRequeridos;
	}
}
