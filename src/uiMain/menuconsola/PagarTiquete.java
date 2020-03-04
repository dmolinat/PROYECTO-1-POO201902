package uiMain.menuconsola;

import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import uiMain.menuconsola.OpcionDeMenu;

public class PagarTiquete extends OpcionDeMenu{
	
	public String mostrar() {
		return "Pagar Tiquete";
	}
	
	public void ejecutar() {
		
		Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		if(!usuario.getTiquetes().isEmpty()) {
			System.out.println("Lista de sus tiquetes: ");
			usuario.mostrarTiquetes();
			System.out.println("Digite el numero de la lista, correspondiente al tiquete que desea pagar");
			int numero = sc.nextInt();
			
			Tiquete tiquete = usuario.seleccionarTiquete(numero);
			
			Pago pago = tiquete.getRefPago();
			
			Tarjeta_des tarjeta = usuario.getAfiliacion();
			
			boolean transaccion = pago.transaccion(tarjeta);
			
			if (transaccion == true) {
				System.out.println("Transaccion exitosa");
				System.out.println("Resumen de la transaccion: ");
				System.out.println("Codigo del pago: " + pago.getCodigo());
				System.out.println("Valor del tiquete: " + pago.getCostoTiquete());
				System.out.println("Valor total (iva incluido): " + pago.getCostoTotal());
			}
			else {
				System.out.println("No tienes saldo suficiente");
			}
		}else {
			System.out.println("No posee tiquetes disponibles a pagar");
		}
		
				
	}
	
}
