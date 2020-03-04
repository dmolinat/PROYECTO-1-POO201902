package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.users.User_R;
import gestorAplicacion.users.Cliente;
import gestorAplicacion.DatosTeatro;

public class NewUser extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		int op;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("Presione 1: Para crear nueva cuenta");
			op=in.nextInt();
			if(op!=1 && op!=2) {
				System.out.println("¡¡ERROR: LA OPCIÓN NO ESTÁ DISPONIBLE!!");
			}
		}while(op!=1 && op!=2);
			(DatosTeatro.U).add(new Cliente().crearUser(op));
		}
		

	@Override
	public String mostrar() {
		return "Registrarse";
	}
	
}
