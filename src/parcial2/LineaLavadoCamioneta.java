package parcial2;

import java.util.ArrayList;

public class LineaLavadoCamioneta extends LineaLavado {

	private Persona ayudante;
	
	public LineaLavadoCamioneta(Persona operario, Persona ayudante) {
		super(operario);
		
		this.ayudante = ayudante;
	}

	
	@Override
	public void registrarVehiculo(Vehiculo vehiculo, ArrayList<Servicio> serviciosRequeridos, Persona conductor, String horaLlegada) throws ExceptionLineaLavado, ExceptionServicioVacio {
		
		
		if (!(vehiculo instanceof Camioneta)){
			throw new ExceptionLineaLavado(vehiculo, this);
		}
		
		if (serviciosRequeridos.isEmpty()) {
			throw new ExceptionServicioVacio(vehiculo);
		}else {
			ClienteEnEspera cliente = new ClienteEnEspera(vehiculo, conductor, horaLlegada, serviciosRequeridos);
			getClientesEnEspera().add(cliente);
		}
				
		
	}
}
