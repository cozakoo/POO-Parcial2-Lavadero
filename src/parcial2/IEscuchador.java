package parcial2;


public interface IEscuchador {
	
	public abstract void notificarAtencion(Persona cliente);
	
	public abstract void notificarFactura(Persona cliente);

}