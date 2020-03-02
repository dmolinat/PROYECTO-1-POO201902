package gestorAplicacion.users;

import java.util.ArrayList;

import gestorAplicacion.Funcion;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class Cliente extends User_R {
	
	//Añadir todas las opciones de menu que existan, pero el Cliente solo podrá
	//acceder a las que estén con available=true
	
	private ArrayList<OpcionDeMenu> opCl = new ArrayList();
	
	public Cliente() {	
	}
	
	public Cliente(String nombre,String apellido,String login,String pass, String document, Integer edad) {
		super(nombre,apellido,login,pass,document,edad);
	}
	public String descripTeatro() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void avOP(OpcionDeMenu Op){
		int indOp=0;
		for(int i=0; i<opCl.size();i++) {
			if(this.opCl.get(i)==Op) {
				indOp=i;
			}
		}
		opCl.get(indOp).setAvailable(true);
	}
	
	public ArrayList<OpcionDeMenu> getOpCl(){
		return this.opCl;
	}

	public ArrayList<Funcion> verF() {
		// TODO Auto-generated method stub
		return null;
	}

}
