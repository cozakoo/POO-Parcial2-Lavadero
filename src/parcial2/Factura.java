package parcial2;

import java.util.ArrayList;

public class Factura {
	
	
	private static int GENERADOR_CODIGO = 1;
	
	private int codigo;
	private String fecha;
	private Persona operador;
	private Persona conductor;
	private Vehiculo vehiculo;
	private LineaLavado linea;
	private TipoPago t_pago;
	private ArrayList<Servicio> serviciosRealizados;
	private double total; 
	
	
	public Factura(String fecha, Persona operador, Persona conductor, Vehiculo vehiculo, LineaLavado linea,
			ArrayList<Servicio> serviciosRealizados, double total) {
		
		this.fecha = fecha;
		this.operador = operador;
		this.conductor = conductor;
		this.vehiculo = vehiculo;
		this.linea = linea;
		this.serviciosRealizados = serviciosRealizados;
		this.total = total;
		this.codigo= GENERADOR_CODIGO++;
	}


	public int getCodigo() {
		return codigo;
	}


	public Persona getConductor() {
		return conductor;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public double getTotal() {
		return total;
	}


	public void setT_pago(TipoPago t_pago) {
		this.t_pago = t_pago;
	}
	
	
	
}
