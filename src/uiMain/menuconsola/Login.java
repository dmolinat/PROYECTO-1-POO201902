package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.users.User_R;
import gestorAplicacion.users.Cliente;

public class Login extends OpcionDeMenu {
	@Override
	
	public void ejecutar() {
		Scanner in = new Scanner(System.in);
		String user,pass,op;
		do {
			System.out.print("Usuario: ");user=in.next();
			System.out.print("Contraseña: ");pass=in.next();
			System.out.print("Presione 1: Para aceptar - Presione 2: Para cancelar ");op=in.next();
			if(op.equals("2")) {
				System.out.print("¿Desea continuar iniciando sesión? -Y para Sí , N para No-: ");op=in.next();
				if(op.equals("N")) {
					break;
				}else {
					user=null;pass=null;
				}
			}
			
		}while(user==null && pass==null);
		if(!op.equals("N")) {
			System.out.println(User_R.LogIn(user,pass));
			((Cliente)DatosTeatro.userLive).Opci();
		}
		
	}

	@Override
	public String mostrar() {
		return "Iniciar Sesión: ";
	}
	
}
