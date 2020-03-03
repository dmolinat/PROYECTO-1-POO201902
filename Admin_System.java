package gestorAplicacion.users;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion; 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class Admin_System extends User_R{ //Administrador_Sistema
	public static ArrayList<OpcionDeMenu> opAdmon = MenuDeConsola.opAdmin;
	private static DatosTeatro datosTeatro = new DatosTeatro();
	
	public Admin_System() {
	}
	
	public Admin_System(String Nombre, String Apellido, String Login, String Pass, String Document,Integer Edad,String Sexo){
		super(Nombre,Apellido,Login,Pass,Document,Edad,Sexo);
	}
	
	//Funcionalidades
	
	
	
	public void añadirOpcionDeMenu(OpcionDeMenu op,String ID) {
		int indCli=0;
		for(int i=0; i<(DatosTeatro.U).size();i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(ID)) {
				indCli=i;
				break;
			}
		}
		//Hay que hacer cast, ya que User_R es el apuntador de los objetos de esta lista
		//y apunta a un objeto de tipo cliente.
		 ((Cliente) (DatosTeatro.U).get(indCli)).avOP(op);
	}
	
	public void mostrarOpcCli(String ID) {
		int indCli=0;
		for(int i=0; i< (DatosTeatro.U).size();i++) {
			if(((DatosTeatro.U).get(i).getLogin()).equals(ID)){
				indCli=i;
			}
		}
		
		ArrayList<OpcionDeMenu> opCl = ((Cliente)(DatosTeatro.U).get(indCli)).getOpCl();
		for(int i=0; i<opCl.size();i++){
			System.out.println("Presiona "+i+": "+ opCl.get(i).mostrar());
		}
	}
	
	
	
	
	
	
	//Get ó Set
	public ArrayList<Object> getVerPerfil(){
		ArrayList<Object> L = new ArrayList();
		return L;
	}
	
	public String descripTeatro() {
		return "Este es el teatro";
	}
	
	
	public ArrayList<Funcion> verF(){
		ArrayList <Funcion> F = new ArrayList();
		return F;
	}
	
}
