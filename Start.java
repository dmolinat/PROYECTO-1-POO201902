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
import uiMain.menuconsola.InInv;
import uiMain.menuconsola.MenuDeConsola;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.Sala;

public class Start {
	
	public static void main(String args[]) {
		//Cargar los datos que se han registrado
		
		if(SaveObject.U_Cli.exists()) {
			SaveObject.Read(SaveObject.U_Cli);
		}
		
		//Primeras Opciones (NO SE QUITAN)
		if(SaveObject.MenIni.exists()) {
			SaveObject.Read(SaveObject.MenIni);
		}else {
			ArrayList<OpcionDeMenu> op1 = DatosTeatro.Ini.getOp();
			(op1).add(new Login());(op1).add(new InInv());(op1).add(new NewUser());
			DatosTeatro.Ini.setOp(op1);
			SaveObject.Write(SaveObject.MenIni);
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
		
		
		
		
		//Agregando Películas
		Pelicula.Cartelera=new ArrayList();
		Pelicula.Cartelera.add(new Pelicula("Sonic La pelicula","Ciencia ficcion","Jeff Fowler",2020));
		Pelicula.Cartelera.add(new Pelicula("Interestelar", "Ciencia ficcion", "Christopher Nolan",2014));
		Pelicula.Cartelera.add(new Pelicula("El Hombre Invisible","Ciencia ficcion","Leigh Whannell",2020));
		Pelicula.Cartelera.add(new Pelicula("El llamado Salvaje","Drama/Aventura","Chris Sanders",2020));
		Pelicula.Cartelera.add(new Pelicula("Los caballeros","Accion","Guy Ritchier",2020));
			
		
		//Agregando Funciones
		ArrayList<Funcion> aux = new ArrayList();
		aux.add(new Funcion(Pelicula.Cartelera.get(0),salas.get(0),new GregorianCalendar(2020, 04, 20, 13, 30)));
		aux.add(new Funcion(Pelicula.Cartelera.get(0),salas.get(1),new GregorianCalendar(2020, 04, 20, 20, 30)));
		aux.add(new Funcion(Pelicula.Cartelera.get(0),salas.get(2),new GregorianCalendar(2020, 04, 21, 13, 30)));
		aux.get(0).anadirAsientos();
		aux.get(1).anadirAsientos();
		aux.get(2).anadirAsientos();
		
		
		Pelicula.Cartelera.get(0).setFuncions(aux);
		
		//Iniciar Programa
		Start.On();
		Start.Off();
		
	}
	
	public static void On() {
		
		
		Scanner in = new Scanner(System.in);
		int op=-1;
		System.out.println("Bienvenido a la APP de Teatros SA");
		do {
			System.out.println(DatosTeatro.Descripcion);
			
			for(int i=0;i<(DatosTeatro.Ini.getOp()).size();i++) {
				System.out.println("Presiona "+i+": para "+((DatosTeatro.Ini.getOp()).get(i).mostrar()));
			}
			System.out.println("Presiona 3: para Salir");
			op=in.nextInt();
			
			if(op!=3) {
				((DatosTeatro.Ini.getOp().get(op))).ejecutar();	
			}
			if(op!=0 && op!=1 && op!=2 && op!=3) {
				System.out.println("ERROR: Esta opción no está disponible");
			}
		}while(op!=3);
		
	}
	
	public static void Off() {
		System.out.println("!!AVISO: se ha salido de la aplicación¡¡");
	}
}
