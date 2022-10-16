package parcial2;

public class Camioneta extends Vehiculo {
	
	private boolean tieneCupula;
	private boolean esDobleCabina;
	
	
	public Camioneta(String dominio, String marca, String modelo, int anioFabricacion, boolean tieneCupula,
			boolean esDobleCabina) {
		super(dominio, marca, modelo, anioFabricacion);
		this.tieneCupula = tieneCupula;
		this.esDobleCabina = esDobleCabina;
	}
}
