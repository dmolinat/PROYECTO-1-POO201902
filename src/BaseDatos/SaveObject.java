package BaseDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import uiMain.menuconsola.CambiarAsiento;
import uiMain.menuconsola.EscogerEvento;
import uiMain.menuconsola.Login;
import uiMain.menuconsola.NewUser;
import uiMain.menuconsola.OpcionDeMenu;
import uiMain.menuconsola.PagarTiquete;
import uiMain.menuconsola.RecargarTarjetad;
import uiMain.menuconsola.Reembolso;
import uiMain.menuconsola.ShowOpc;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Pelicula;
import gestorAplicacion.Sala;
import gestorAplicacion.users.Cliente;

public class SaveObject {
	//Usuarios
	public static File U_Cli = new File(System.getProperty("user.dir") + "\\src\\BaseDatos"+ "\\UsersClients.txt");
	
	//Peliculas
	public static File Peli = new File(System.getProperty("user.dir") + "\\src\\BaseDatos"+ "\\Peliculas.txt");
	
	//Salas
	public static File Sal = new File(System.getProperty("user.dir") + "\\src\\BaseDatos"+ "\\Salas.txt");
	
	//Menus
	public static File Menu = new File(System.getProperty("user.dir") + "\\src\\BaseDatos"+"\\Menus.txt");
	public static File MenIni = new File(System.getProperty("user.dir") + "\\src\\BaseDatos"+"\\MenuInicio.txt");
	
	public static void Write(File n, ArrayList<Object> A){
		try{
			FileWriter x = new FileWriter(n,true);
			BufferedWriter y = new BufferedWriter (x);
			PrintWriter z = new PrintWriter (x); 
			z.print((String)A.get(0));
           
			for(int i=1;i<A.size();i++){
				if(i==5){
					String aux = "" + A.get(i); 
                    z.print(",");z.print(aux);
                }else{
                    z.print(",");z.print((String)A.get(i));
                }           
              }
			z.println();
			
			y.close();
			z.close();
		}catch (Exception e) {
			System.out.println("Hay un error "+e);
		}
	}
	
	public static void Write(File n){
		try{
			if(n == SaveObject.MenIni) {
				ArrayList<OpcionDeMenu> A = DatosTeatro.Ini.getOp();
				FileWriter x = new FileWriter(n,true);
				BufferedWriter y = new BufferedWriter (x);
				PrintWriter z = new PrintWriter (x); 
				z.print((OpcionDeMenu)A.get(0));
	           
				for(int i=1;i<A.size();i++){
	                   z.print(",");z.print((OpcionDeMenu)A.get(i));         
	              }
				
				z.println();
				y.close();
				z.close();
			}else if(n== SaveObject.Menu) {
				ArrayList<OpcionDeMenu> A = DatosTeatro.opCli;
				FileWriter x = new FileWriter(n,true);
				BufferedWriter y = new BufferedWriter (x);
				PrintWriter z = new PrintWriter (x); 
				z.print((OpcionDeMenu)A.get(0));
	           
				for(int i=1;i<A.size();i++){
	                   z.print(",");z.print((OpcionDeMenu)A.get(i));         
	              }
				
				z.println();
				y.close();
				z.close();
				
			}

		}catch (Exception e) {
			System.out.println("Hay un error "+e);
		}
	}
	
	
	//SOBRECARGA DE MÉTODOS
	public static void Read(File n) {
		try{
			FileReader x1= new FileReader(n);
			BufferedReader y1= new BufferedReader(x1);
			String aux;
			aux=y1.readLine();
			while(aux != null) {
				Object [] x = aux.split(",");
				if(n == SaveObject.U_Cli) {
					DatosTeatro.U.add(new Cliente((String)x[0],(String)x[1],(String)x[2],(String)x[3],(String)x[4],Integer.parseInt((String)x[5])));
				}else if (n==SaveObject.MenIni) {
					ArrayList<OpcionDeMenu> aux1 = new ArrayList();
					aux1.add((OpcionDeMenu)new Login());
					aux1.add((OpcionDeMenu)new NewUser());
					DatosTeatro.Ini.setOp(aux1);
				}else if(n==SaveObject.Menu) {
					(DatosTeatro.opCli).add((OpcionDeMenu)new EscogerEvento());
					(DatosTeatro.opCli).add((OpcionDeMenu)new PagarTiquete());
					(DatosTeatro.opCli).add((OpcionDeMenu)new Reembolso());
					(DatosTeatro.opCli).add((OpcionDeMenu)new CambiarAsiento());
					(DatosTeatro.opCli).add((OpcionDeMenu)new ShowOpc());
					(DatosTeatro.opCli).add((OpcionDeMenu)new RecargarTarjetad());
				}else if (n==SaveObject.Peli) {
					//Cargar las peliculaS
					Pelicula y = new Pelicula((String)x[0],(String)x[1],(String)x[2],Integer.parseInt((String)x[3]));
					(Pelicula.Cartelera).add(y);
				}else if(n==SaveObject.Sal) {
					//Cargar Salas
					Sala z = new Sala(Integer.parseInt((String)x[0]),Integer.parseInt((String)x[1]));
					(DatosTeatro.S).add(z);
				}
				
				aux=y1.readLine();
			}
			x1.close();
			y1.close();
			
		}catch (IOException e) {
			System.out.println("Hay un error "+e);
		}
	}
}
