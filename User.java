package gestorAplicacion.users;
import java.util.LinkedList;
public interface User {
	
	public String descripTeatro();
	public LinkedList<Funcion> verF();
	public boolean crearUser();
	
}
