package uiMain.menuconsola;

import java.util.Scanner;

import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import uiMain.OpcionDeMenu;

public class Reembolso extends OpcionDeMenu {

	public void mostrar() {
	}
	
	public void ejecutar() {
		
		Scanner sc = new Scanner(System.in);
		
		Cliente usuario; //esta variable hay que apuntarla al cliente que esta loggeado
		
		System.out.println("Lista de sus tiquetes: ");
		usuario.mostrarTiquetes();
		System.out.println("Digite el numero de la lista, correspondiente al tiquete al cual desea solicitar un reembolso y cancelar su asistencia");
		int numero = sc.nextInt();
		
		Tiquete tiquete = usuario.seleccionarTiquete(numero);
		
		Pago pago = tiquete.getRefPago();
		
		Tarjeta_des tarjeta = usuario.getAfiliacion();
		
		boolean operacion = pago.reembolso(tarjeta);
		if (operacion == true) {
			System.out.println("Reembolso exitoso!");
			System.out.println("Asistencia cancelada correctamente");
		}
		else {
			System.out.println("Lo sentimos, faltan 24 horas o menos para el evento. No aplicas para reembolso");
			System.out.println("Asistencia cancelada correctamente");
		}
	}
}
