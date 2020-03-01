package uiMain;
import gestorAplicacion.users.Admin_System;
import gestorAplicacion.users.Cliente;
import gestorAplicacion.users.User_Invi;
import gestorAplicacion.users.User_R;
import java.util.Scanner;
import gestorAplicacion.DatosTeatro;

public class Start {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int op=-1;
		String user;
		String pass;
		
		System.out.println("Bienvenido a la APP de Teatros SA");
		do {
			System.out.println("Presione 0: Para iniciar sesión.");
			System.out.println("Presiona 1: Para entrar como invitado.");
			System.out.println("Presiona 2: Para registrarse.");
			op=in.nextInt();
			if(op!=0 && op!=1 && op!=2) {
				System.out.println("ERROR: Esta opción no está disponible");
			}
			
		}while(op!=0 && op!=1 && op!=2);
		
		if(op==0) {
			System.out.print("User: "); user=in.next();
			System.out.print("Pass: "); pass=in.next();
			//Codigo para reconocer si es Cliente o Admin
		}else if(op==1) {
			(DatosTeatro.Ui).add(new User_Invi());
		}else{
			(DatosTeatro.U).add((new Cliente()).crearUser());
			//No importa quien llame la función porque
			//al ejecutarse el método crearUser, va a devolver un nuevo objeto.
			//new Cliente() acá se usa como una instancia auxiliar
		}
	}
}
