package uiMain.menuconsola;

import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import uiMain.menuconsola.OpcionDeMenu;
import gestorAplicacion.transaccion.Tarjeta_des;

public class Reembolso extends OpcionDeMenu {

	public String mostrar() {
		return "Solicitar reembolso y cancelar asistencia: ";
	}
	
	public void ejecutar() {
		
		Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al cliente que esta loggeado
		
		if(!usuario.getTiquetes().isEmpty()) {
		System.out.println("Lista de sus tiquetes: ");
		usuario.mostrarTiquetes();
		System.out.println("Digite el numero de la lista, correspondiente al tiquete al cual desea solicitar un reembolso y cancelar su asistencia");
		
		Tiquete tiquete=null;
		do{
			int numero = sc.nextInt();
			tiquete = usuario.seleccionarTiquete(numero);
			if(tiquete==null) {
				System.out.println("AVISO: El tiquete seleccionado no se encuentra disponible");
			}
		}while(tiquete==null);
		
		
		Pago pago = tiquete.getRefPago();
		
		Tarjeta_des tarjeta = usuario.getAfiliacion();
		
		if(pago.isPagado()) {
			boolean operacion = pago.reembolso(tarjeta);
			if (operacion == true) {
				System.out.println("Reembolso exitoso!");
				System.out.println("Asistencia cancelada correctamente");
			}
			else {
				System.out.println("Lo sentimos, faltan 24 horas o menos para el evento. No aplicas para reembolso");
				System.out.println("Asistencia cancelada correctamente");
			}
		}else {
			System.out.println("No se ha efectuado el pago del tiquete primero");
		}
		
		
		}else {
			System.out.println("No posee tiquetes disponibles a pagar");
		}
	}
}
