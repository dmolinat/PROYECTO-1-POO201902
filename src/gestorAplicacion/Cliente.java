package gestorAplicacion.users;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class Cliente extends User_R {
	
	//Añadir todas las opciones de menu que existan, pero el Cliente solo podrá
	//acceder a las que estén con available=true
	
	private MenuDeConsola MenCli = new MenuDeConsola();
	
	public Cliente() {	
	}
	
	public Cliente(String nombre,String apellido,String login,String pass, String document, Integer edad) {
		super(nombre,apellido,login,pass,document,edad);
	}
	public String descripTeatro() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void Opci() {
		Scanner in = new Scanner(System.in);
		int op=0;
		do {
			MenuDeConsola.lanzarMenu(((Admin_System)DatosTeatro.userLive).getMenAdmin().getOp());
			System.out.println("Presiona "+ ((Admin_System)DatosTeatro.userLive).getMenAdmin().getOp().size() + ": Para salir");
			op=in.nextInt();
			
			if(op!=((Admin_System)DatosTeatro.userLive).getMenAdmin().getOp().size()) {
				((Admin_System)DatosTeatro.userLive).getMenAdmin().getOp().get(op).ejecutar();
			}
		}while(op!=((Admin_System)DatosTeatro.userLive).getMenAdmin().getOp().size());	
	}
	public 
	
	
	
	public MenuDeConsola getMenCli(){
		return this.MenCli;
	}
	

	public ArrayList<Funcion> verF() {
		// TODO Auto-generated method stub
		return null;
	}

}
