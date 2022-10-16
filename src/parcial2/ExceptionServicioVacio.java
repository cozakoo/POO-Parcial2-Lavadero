package parcial2;

public class ExceptionServicioVacio extends Exception {

	private Vehiculo vehiculo;
	
	public ExceptionServicioVacio(Vehiculo vehiculo) {
		
		this.vehiculo = vehiculo;
	}
	
	
	@Override
	public String getMessage() {
		return String.format("No hay servicios requeridos en el vehiculo con patente %d",
				vehiculo.getDominio());
	}
}
