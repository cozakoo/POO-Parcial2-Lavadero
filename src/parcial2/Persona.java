package parcial2;

public class Persona {
	
	private TipoDocumento t_documento;
	private String nombre, apellido;
	private int numeroDocumento;
	
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Persona(TipoDocumento t_documento, int numeroDocumento, String nombre, String apellido) {
		super();
		this.t_documento = t_documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDocumento = numeroDocumento;
	}

	@Override
	public String toString() {
		return String.format("%s %s",
				this.nombre,
				this.apellido);
	}
}
