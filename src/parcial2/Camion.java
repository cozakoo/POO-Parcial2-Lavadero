package parcial2;

public class Camion extends Vehiculo{
	
	private int ejes, largoAcoplado;
	
	public Camion(String dominio, String marca, String modelo, int anioFabricacion, int ejes, int largoAcoplado) {
		super(dominio, marca, modelo, anioFabricacion);
		
		this.ejes = ejes;
		this.largoAcoplado = largoAcoplado;	
	}
}
