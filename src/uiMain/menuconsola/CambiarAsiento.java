package uiMain.menuconsola;

import java.util.Scanner;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import uiMain.menuconsola.OpcionDeMenu;

public class CambiarAsiento extends OpcionDeMenu {
	
	public String mostrar() {
		return "Cambiar Asiento: ";
	}
	
	public void ejecutar() {
		
		Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
		System.out.println("Lista de sus tiquetes: ");
		usuario.mostrarTiquetes();
		if (usuario.getTiquetes().isEmpty()) {
			System.out.println("No tiene tiquetes asignados");
			return;
		}
		
		System.out.println("Digite el numero de la lista, correspondiente al tiquete al cual desea cambiar el asiento");
		int numero = sc.nextInt();
		
		Tiquete tiquete = usuario.seleccionarTiquete(numero);
		
		System.out.println("Lista de asientos disponibles: ");
		Funcion funcion = tiquete.getEvento();
		boolean verAsientos = funcion.verAsientosDisponibles();
		if (verAsientos == false) {
			System.out.println("No hay asientos disponibles");
			return;
		}
		
		System.out.println("Por favor, escriba el codigo del asiento deseado");
		System.out.println("El codigo debe tener la siguiente estructura: una letra al inicio (A-H) y un numero al final (0 al 9)");
		System.out.println("Ejemplos: A0, B6, H9");
		System.out.println("Asientos que empiezan por A y B son privados, tienen un costo de 10.000");
		System.out.println("Los demas asientos son comunes, tienen un valor de 5.000");
		
		String codigoAsiento = sc.next();
		Asiento asiento = funcion.buscarAsiento(codigoAsiento);
		
		if (asiento == null) {
			System.out.println("Codigo de asiento invalido");
			return;
		}
		else {
			boolean cambiar = tiquete.cambiarAsiento(asiento);
			if (cambiar == true) {
				System.out.println("Asiento cambiado correctamente");
			}
			else {
				System.out.println("El asiento no esta disponible, o el evento ya paso");
				return;
			}
		}
		
	}
}
