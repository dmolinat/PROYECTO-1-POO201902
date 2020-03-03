package gestorAplicacion.users;
import java.util.ArrayList;
import gestorAplicacion.Funcion;

public interface User {
	
	public String descripTeatro();
	public ArrayList<Funcion> verF();
	public  User_R crearUser(int Op);
	
}
