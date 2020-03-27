package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.users.Cliente;

import gestorAplicacion.DatosTeatro;

public class RecargarTarjetad extends OpcionDeMenu{

	@Override
	public void ejecutar() {
		Scanner in = new Scanner(System.in);
		System.out.println("Su saldo es de: "+((Cliente)DatosTeatro.userLive).getAfiliacion().getValorRecargado());
		
		
		
		double op=-1.0;
		do{
			System.out.println("¿Cuánto es el monto que desea mandar?");
			op=in.nextDouble();	
			if(op<0) {
				System.out.println("AVISO: El monto seleccionado no se puede recargar");
			}
		}while(op<0);
		
		((Cliente)DatosTeatro.userLive).RecargarTarjeta(op);
		
		System.out.println("Su nuevo saldo es de: "+((Cliente)DatosTeatro.userLive).getAfiliacion().getValorRecargado());
		
		
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Recargar tarjeta: ";
	}

}
