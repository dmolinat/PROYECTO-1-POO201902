package gestorAplicacion;

import java.util.ArrayList;

import gestorAplicacion.users.Cliente;
import gestorAplicacion.users.User;
import gestorAplicacion.users.User_R;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;


public class DatosTeatro {
	
	public static User_R userLive;
	public static MenuDeConsola Ini = new MenuDeConsola();
	public static ArrayList<OpcionDeMenu> opCli = new ArrayList();
	public static ArrayList<User_R> U = new ArrayList();
	public static ArrayList<MenuDeConsola> Men = new ArrayList();
	
	private static int PersonaTeatro = U.size();
	private int GananciasDiarias = 0;
	public static String Descripcion = "";
	private static ArrayList <Funcion> F = new ArrayList();
	
	public static ArrayList<String> IDCli() {
		ArrayList<String> Id = new ArrayList();
		int con=0;
		for(int i=0; i < U.size(); i++) {
			if(U.get(i) instanceof Cliente) {
				Id.add(U.get(i).getLogin());
			}
		}
		return Id;
	}
	
	public int getPersonaTeatro() {
		return PersonaTeatro;
	}
	
	public int getGanaciasDiarias() {
		return GananciasDiarias;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
	
	public void setDescripcion(String Descripcion) {
		this.Descripcion=Descripcion;
	}
}
