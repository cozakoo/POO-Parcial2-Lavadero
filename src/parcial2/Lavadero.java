package parcial2;

import java.util.ArrayList;

public class Lavadero implements IEscuchador {
	
	private static Lavadero instancia;
	private String razonSocial, direccion;
	private Persona encargado;
	private ArrayList<LineaLavado> lineasLavados;
	

	public Lavadero(String razonSocial) {
		this.razonSocial = razonSocial;
		this.lineasLavados = new ArrayList<LineaLavado>();
	}
	
	public static Lavadero getInstancia(String razonSocial) {
		if(instancia == null)
			instancia = new Lavadero(razonSocial);
		return instancia;
	}
	
	
	public void imprimirFacturas() {

		double totalRecaudado = 0.0;
		for(LineaLavado l: this.lineasLavados) {
			
			if (!(l.getFacturas().isEmpty()))
			{
				System.out.println(String.format("\n FACTURAS REALIZADAS DEL LAVADERO %d", l.getCodigo()));
				l.imprimirFacturas();
				totalRecaudado += l.montoTotalFacturas();
				
			}else
				System.out.println(String.format("\n EL LAVADERO %d NO TIENE FACTURAS REALIZADAS", l.getCodigo()));
		}
		
		System.out.println(String.format("\n MONTO TOTAL RECAUDADO %.2f ", totalRecaudado));
	}

	
	@Override
	public void notificarAtencion(Persona cliente) {
		System.out.println(String.format("\nSe esta atendiendo al cliente %s",
				cliente.toString()));		
	}

	@Override
	public void notificarFactura(Persona cliente){
		System.out.println(String.format("Se esta generando una factura para el cliente %s",
				cliente.toString()));
	}

	public void agregarLineaLavado(LineaLavado l) {
		this.lineasLavados.add(l);
	}
}
