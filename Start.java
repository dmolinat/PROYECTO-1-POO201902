package uiMain;

import java.util.Scanner;
import java.util.ArrayList;

import uiMain.menuconsola.OpcionDeMenu;
import uiMain.menuconsola.Login;
import uiMain.menuconsola.newUser;
import gestorAplicacion.users.Admin_System;
import gestorAplicacion.users.Cliente;
import gestorAplicacion.users.User_Invi;
import gestorAplicacion.users.User_R;
import uiMain.menuconsola.InInv;
import uiMain.menuconsola.MenuDeConsola;

import gestorAplicacion.DatosTeatro;

public class Start {
	
	public static void main(String args[]) {
		Start.On();
		Start.Off();
	}
	
	public static void On() {
		
		(MenuDeConsola.OP1).add(new Login());(MenuDeConsola.OP1).add(new InInv());(MenuDeConsola.OP1).add(new newUser());
		Scanner in = new Scanner(System.in);
		int op=-1;
		System.out.println("Bienvenido a la APP de Teatros SA");
		do {
			for(int i=0;i<(MenuDeConsola.OP1).size();i++) {
				System.out.println("Presiona "+i+": para "+((MenuDeConsola.OP1).get(i)).mostrar());
			}
			System.out.println("Presiona 3: para Salir");
			op=in.nextInt();
			
			if(op!=3) {
				((MenuDeConsola.OP1).get(op)).ejecutar();
			}
			
			if(op!=0 && op!=1 && op!=2 && op!=3) {
				System.out.println("ERROR: Esta opción no está disponible");
			}
		}while(op!=3);
		
	}
	
	public static void Off() {
		System.out.println("!!AVISO: Programa Acabado¡¡");
	}
}
