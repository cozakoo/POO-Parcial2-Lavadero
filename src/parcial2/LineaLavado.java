package parcial2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LineaLavado {
	
	private static int GENERADOR_CODIGO = 1;
	
	private int codigo;
	private Persona operario;
	
	private Queue<ClienteEnEspera> clientesEnEspera;
	private ArrayList<Factura> facturas;
	private ArrayList<Servicio> servicicios; 
	private ArrayList<IEscuchador> escuchadores; 
	
	
	public LineaLavado(Persona operario) {
		this.codigo= GENERADOR_CODIGO++;
		this.operario = operario;
		
		this.clientesEnEspera = new LinkedList<ClienteEnEspera>();
		this.facturas = new ArrayList<Factura>();
		this.servicicios = new ArrayList<Servicio>();
		this.escuchadores = new ArrayList<IEscuchador>();
	}
	

	public void atenderCliente(String fecha) {
		
		ClienteEnEspera c = this.clientesEnEspera.peek();
		this.clientesEnEspera.poll();

		//notifico
		this.notificarAtencionVehiculo(c.getConductor());
		
		System.out.println("vehiculo lavado...");
		
		double total= 0.0;
		
		for (Servicio s: c.getServiciosRequeridos())
			total += s.getCosto();
	
		
		emitirFactura(c,fecha, total);
	}
	
	
	private void notificarAtencionVehiculo(Persona cliente) {

		for (IEscuchador e: this.escuchadores) 
			e.notificarAtencion(cliente);
	}


	public void registrarVehiculo(Vehiculo vehiculo, ArrayList<Servicio> serviciosRequeridos, Persona conductor, String horaLlegada) throws ExceptionLineaLavado, ExceptionServicioVacio {
			
		if ((vehiculo instanceof Camion) || (vehiculo instanceof Camioneta))
			throw new ExceptionLineaLavado(vehiculo, this);
		
		if (serviciosRequeridos.isEmpty())
			throw new ExceptionServicioVacio(vehiculo);
		else {
			ClienteEnEspera cliente = new ClienteEnEspera(vehiculo, conductor, horaLlegada, serviciosRequeridos);
			this.clientesEnEspera.add(cliente);
		}
	}

	protected void emitirFactura(ClienteEnEspera c, String fecha, double total) {
		
		Factura factura = new Factura(fecha, this.operario, c.getConductor(), c.getVehiculo(), this, c.getServiciosRequeridos(), total);
		
		//notifico
		this.notificarEmisionDeFactura(c.getConductor());
		
		int i = (int) (Math.random()* 3+1);
		
		switch (i)
		{
		case 1: factura.setT_pago(TipoPago.CREDITO);
				break;
		case 2: factura.setT_pago(TipoPago.DEBITO);
				break;
		case 3: factura.setT_pago(TipoPago.EFECTIVO);
				break;
		}

		
		this.facturas.add(factura);

	}

	protected void notificarEmisionDeFactura(Persona cliente) {
		
		for (IEscuchador e: this.escuchadores) 
			e.notificarFactura(cliente);
	}

	public void agregarServicio(Servicio s) {
		this.servicicios.add(s);
	}


	public Queue<ClienteEnEspera> getClientesEnEspera() {
		return clientesEnEspera;
	}

	public void agregarEscuchador(IEscuchador escuchador) {
		this.escuchadores.add(escuchador);
	}


	public ArrayList<Factura> getFacturas() {
		return facturas;
	}


	public void imprimirFacturas() {

		for (Factura f : this.facturas){
			System.out.println(String.format("%d - %s - %s - %.2f",
					f.getCodigo(),
					f.getConductor().toString(),
					f.getVehiculo().getDominio(),
					f.getTotal()));
		}
	}

	public double montoTotalFacturas(){
		double total = 0.0; 
		
		for (Factura f : this.facturas)
			total += f.getTotal();
		
		return total;
	}

	public int getCodigo() {
		return codigo;
	}
}
