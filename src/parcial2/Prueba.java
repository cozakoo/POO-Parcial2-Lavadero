package parcial2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) throws ExceptionLineaLavado, ExceptionServicioVacio {

		
		Lavadero lavadero  = Lavadero.getInstancia("DON JUAN");
		
		Persona operario1 = new Persona("JUAN ", "RAMIRO");
		Persona operario2 = new Persona("Victor", "Tapia");
		Persona operario3 = new Persona("Jose", "Zen");
		Persona operario4 = new Persona("Armando", "Lopez");		
				
		ArrayList<LineaLavado> lineas = new ArrayList<>();
		LineaLavado lv = new LineaLavado(operario1);
		LineaLavadoCamion lvCamion = new LineaLavadoCamion(operario2, operario3);
		LineaLavadoCamioneta lvCamioneta = new LineaLavadoCamioneta(operario4, operario1);
		
		lineas.add(lv);
		lineas.add(lvCamioneta);
		lineas.add(lvCamion);
		
		lv.agregarEscuchador(lavadero);
		lvCamion.agregarEscuchador(lavadero);
		lvCamioneta.agregarEscuchador(lavadero);
		
		lavadero.agregarLineaLavado(lvCamioneta);
		lavadero.agregarLineaLavado(lvCamion);
		lavadero.agregarLineaLavado(lv);
				
		//CONDUCTORES
		Persona conductor1 = new Persona(TipoDocumento.DNI, 23344455,"Hernan", "Perez");
		Persona conductor2 = new Persona(TipoDocumento.LC, 753536,"German", "Chuster");
		Persona conductor3 = new Persona(TipoDocumento.LI, 95436364,"Nicolas", "Alfonso");
		Persona conductor4 = new Persona(TipoDocumento.PASAPORTE, 73568865,"Armando", "Lopez");

		
		Camion camion1 = new Camion("EWE 852", "Volvo", "C2", 2000, 4, 14);
		Camion camion2 = new Camion("GDS 343", "Volvswagen", "C90", 2016, 6, 13);

		Vehiculo vehiculo1 = new Vehiculo("GSC 111", "Kia", "Sorento", 2016);
		Vehiculo vehiculo2 = new Vehiculo("PLW 987", "Hiundai", "Citroen", 2000);
		
		Camioneta camioneta1 = new Camioneta("SFS 432", "Huinday", "SDS", 1994, true, false);
		Camioneta camioneta2 = new Camioneta("DGTR 34", "Kia", "SFDDD", 1422, false, true);

		
		Servicio s1 = new Servicio("tapizado", 1234);
		Servicio s2 = new Servicio("aspirado", 4432);
		Servicio s3 = new Servicio("limpieza de ruedas", 4312);
		Servicio s4 = new Servicio("limpieza de vidrio", 4223);
		Servicio s5 = new Servicio("lubricar", 2131);
		
		lv.agregarServicio(s1);
		lv.agregarServicio(s2);
		lv.agregarServicio(s3);
		lv.agregarServicio(s4);
		lv.agregarServicio(s5);
		
		lvCamion.agregarServicio(s1);
		lvCamion.agregarServicio(s2);
		lvCamion.agregarServicio(s3);
		lvCamion.agregarServicio(s4);
		lvCamion.agregarServicio(s5);
		
		lvCamioneta.agregarServicio(s1);
		lvCamioneta.agregarServicio(s2);
		lvCamioneta.agregarServicio(s3);
		lvCamioneta.agregarServicio(s4);
		lvCamioneta.agregarServicio(s5);
		
		ArrayList<Servicio> listaServicio1 = new ArrayList<>();
		listaServicio1.add(s4);
		listaServicio1.add(s5);
		listaServicio1.add(s2);
		
		ArrayList<Servicio> listaServicio2 = new ArrayList<>();
		listaServicio2.add(s1);
		listaServicio2.add(s2);
		listaServicio2.add(s3);

		
		try {
			
			lv.registrarVehiculo(vehiculo1, listaServicio2, conductor1, "13:22");
			lv.registrarVehiculo(vehiculo2, listaServicio1, conductor2, "14:21");
			
			lvCamion.registrarVehiculo(camion1, listaServicio1, conductor3, "15:22");
			lvCamion.registrarVehiculo(camion2, listaServicio2, conductor4, "18:21");
			
			lvCamioneta.registrarVehiculo(camioneta1, listaServicio2, conductor2, "23:22");
			lvCamioneta.registrarVehiculo(camioneta2, listaServicio1, conductor4, "09:21");
		
			//casos de excepciones
			lv.registrarVehiculo(camion1, listaServicio1, conductor3, "15:22");		
			lvCamioneta.registrarVehiculo(camion1, listaServicio1, conductor4, "09:21");

			
		} catch (ExceptionLineaLavado e) {
			System.out.println(e.getMessage());
		} catch (ExceptionServicioVacio e) {
			System.out.println(e.getMessage());
		}finally {
			
			
			for (LineaLavado l : lineas)
			{
				while (!(l.getClientesEnEspera().isEmpty()))
					l.atenderCliente("25/11/2020");
			
			}
			lavadero.imprimirFacturas();
		}
	}
}
