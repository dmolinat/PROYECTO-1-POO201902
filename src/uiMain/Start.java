package uiMain;

import java.util.Scanner;

import BaseDatos.SaveObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import uiMain.menuconsola.OpcionDeMenu;
import uiMain.menuconsola.PagarTiquete;
import uiMain.menuconsola.RecargarTarjetad;
import uiMain.menuconsola.Reembolso;
import uiMain.menuconsola.ShowOpc;
import uiMain.menuconsola.Login;
import uiMain.menuconsola.NewUser;
import gestorAplicacion.users.Cliente;
import gestorAplicacion.users.User_R;
import uiMain.menuconsola.CambiarAsiento;
import uiMain.menuconsola.EscogerEvento;
import uiMain.menuconsola.MenuDeConsola;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.Sala;

public class Start {
	private static boolean off=true;
	
	public static boolean getOff() {
		return off;
	}
	public static void setOff() {
		off=false;
	}
	
	public static void On() {
		
		//Cargar los datos que se han registrado
		
				if(SaveObject.U_Cli.exists()) {
					SaveObject.Read(SaveObject.U_Cli);
				}
				
				//Primeras Opciones (NO SE QUITAN)
				if(SaveObject.MenIni.exists()) {
					SaveObject.Read(SaveObject.MenIni);
				}else {
					ArrayList<OpcionDeMenu> op1 = DatosTeatro.Ini.getOp();
					(op1).add(new Login());(op1).add(new NewUser());
					DatosTeatro.Ini.setOp(op1);
					SaveObject.Write(SaveObject.MenIni);
				}
				
				//Cargar las peliculas
				if(SaveObject.Peli.exists()) {
					SaveObject.Read(SaveObject.Peli);
				}
				
				//Cargar Salas:
				if(SaveObject.Sal.exists()) {
					SaveObject.Read(SaveObject.Sal);
				}
				
				
				//Cargar lista general de Opciones (Tanto para Admin como para Clientes)
				if(SaveObject.Menu.exists()) {
					SaveObject.Read(SaveObject.Menu);
				}else {
					(DatosTeatro.opCli).add((OpcionDeMenu)new EscogerEvento());
					(DatosTeatro.opCli).add((OpcionDeMenu)new PagarTiquete());
					(DatosTeatro.opCli).add((OpcionDeMenu)new Reembolso());
					(DatosTeatro.opCli).add((OpcionDeMenu)new CambiarAsiento());
					(DatosTeatro.opCli).add((OpcionDeMenu)new ShowOpc());
					(DatosTeatro.opCli).add((OpcionDeMenu)new RecargarTarjetad());
					SaveObject.Write(SaveObject.Menu);
				}
				
				
				//Agregando Salas
				ArrayList<Sala> salas = new ArrayList();
				salas.add(new Sala(1,80));salas.add(new Sala(2,80));salas.add(new Sala(3,80));	
				
				//Agregando Funciones
				ArrayList<Funcion> aux = new ArrayList();
				aux.add(new Funcion(Pelicula.Cartelera.get(0),(DatosTeatro.S).get(0),new GregorianCalendar(2020, 04, 16, 13, 30)));
				aux.add(new Funcion(Pelicula.Cartelera.get(0),(DatosTeatro.S).get(1),new GregorianCalendar(2020, 04, 17, 20, 30)));
				aux.add(new Funcion(Pelicula.Cartelera.get(0),(DatosTeatro.S).get(2),new GregorianCalendar(2020, 04, 21, 13, 30)));
				
				ArrayList<Funcion> aux1 = new ArrayList();
				aux1.add(new Funcion(Pelicula.Cartelera.get(1),(DatosTeatro.S).get(0),new GregorianCalendar(2020, 02, 24, 9, 30)));
				aux1.add(new Funcion(Pelicula.Cartelera.get(1),(DatosTeatro.S).get(4),new GregorianCalendar(2020, 04, 20, 20, 30)));
				aux1.add(new Funcion(Pelicula.Cartelera.get(1),(DatosTeatro.S).get(3),new GregorianCalendar(2020, 04, 1, 23, 30)));
			
				ArrayList<Funcion> aux2 = new ArrayList();
				aux2.add(new Funcion(Pelicula.Cartelera.get(2),(DatosTeatro.S).get(3),new GregorianCalendar(2020, 03, 29, 13, 30)));
				aux2.add(new Funcion(Pelicula.Cartelera.get(2),(DatosTeatro.S).get(2),new GregorianCalendar(2020, 03, 30, 20, 30)));
				aux2.add(new Funcion(Pelicula.Cartelera.get(2),(DatosTeatro.S).get(1),new GregorianCalendar(2020, 04, 3, 22, 30)));
				
				ArrayList<Funcion> aux3 = new ArrayList();
				aux3.add(new Funcion(Pelicula.Cartelera.get(3),(DatosTeatro.S).get(3),new GregorianCalendar(2020, 04, 10, 13, 30)));
				aux3.add(new Funcion(Pelicula.Cartelera.get(3),(DatosTeatro.S).get(3),new GregorianCalendar(2020, 04, 12, 20, 30)));
				aux3.add(new Funcion(Pelicula.Cartelera.get(3),(DatosTeatro.S).get(4),new GregorianCalendar(2020, 03, 29, 21, 30)));
				
				ArrayList<Funcion> aux4 = new ArrayList();
				aux4.add(new Funcion(Pelicula.Cartelera.get(4),(DatosTeatro.S).get(0),new GregorianCalendar(2020, 03, 30, 13, 30)));
				aux4.add(new Funcion(Pelicula.Cartelera.get(4),(DatosTeatro.S).get(0),new GregorianCalendar(2020, 04, 15, 20, 30)));
				aux4.add(new Funcion(Pelicula.Cartelera.get(4),(DatosTeatro.S).get(2),new GregorianCalendar(2020, 04, 12, 20, 30)));
				
				
				for(int i=0;i<aux.size();i++) {
					aux.get(i).anadirAsientos();
					aux1.get(i).anadirAsientos();
					aux2.get(i).anadirAsientos();
					aux3.get(i).anadirAsientos();
					aux4.get(i).anadirAsientos();
				}
				
				for(int i=0;i<Pelicula.Cartelera.size();i++) {
					if(i==0) {
						Pelicula.Cartelera.get(i).setFuncions(aux);;
					}else if (i==1) {
						Pelicula.Cartelera.get(i).setFuncions(aux1);
					}else if(i==2) {
						Pelicula.Cartelera.get(i).setFuncions(aux2);
					}else if(i==3) {
						Pelicula.Cartelera.get(i).setFuncions(aux3);
					}else {
						Pelicula.Cartelera.get(i).setFuncions(aux4);
					}
				}
		
		
		//Primeras opciones		
		//Scanner in = new Scanner(System.in);
		//int op=-1;
		//off = true;
		//do {
			//for(int i=0;i<(DatosTeatro.Ini.getOp()).size();i++) {
				//System.out.println("Presiona "+i+": para "+((DatosTeatro.Ini.getOp()).get(i).mostrar()));
			//}
			//System.out.println("Presiona 3: para Salir");
			//op=in.nextInt();
			
			//if(op!=3) {
			//	((DatosTeatro.Ini.getOp().get(op))).ejecutar();	
			//}
			//if(op!=0 && op!=1 && op!=2 && op!=3) {
			//	System.out.println("ERROR: Esta opción no está disponible");
			//}
		//}while(off);
		
	}
	public static void Off() {
		System.out.println("!!AVISO: se ha salido de la aplicación¡¡");
	}
}