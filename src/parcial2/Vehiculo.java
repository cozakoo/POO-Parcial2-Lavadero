package parcial2;

public class Vehiculo {
	
	private String dominio, marca, modelo;
	private int anioFabricacion;
	
	public Vehiculo(String dominio, String marca, String modelo, int anioFabricacion) {
		this.dominio = dominio;
		this.marca = marca;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
	}

	public String getDominio() {
		return dominio;
	}

	@Override
	public String toString() {
		
		return String.format("%s - s - s" ,
				this.dominio,
				this.marca,
				this.modelo);
	}
	
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Vehiculo) {
			Vehiculo v1 = (Vehiculo) obj;

			return (this.dominio == v1.getDominio());
		} else
			return false;
	}
}
