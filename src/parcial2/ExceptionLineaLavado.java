package parcial2;

public class ExceptionLineaLavado extends Exception {
	
	
	private Vehiculo vehiculo;
	private LineaLavado linea; 
	
	public ExceptionLineaLavado(Vehiculo v, LineaLavado linea ) {
		
		this.vehiculo = v;
		this.linea = linea;
	}
	
	@Override
	public String getMessage() {
		return String.format("No se puede ingresar el vehiculo con patente %s a la linea de lavado %d",
				this.vehiculo.getDominio(),
				this.linea.getCodigo());
	}

}