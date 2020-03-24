package uiMain.menuconsola;

import java.util.Scanner;

import BaseDatos.SaveObject;
import gestorAplicacion.users.User_R;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import gestorAplicacion.users.Cliente;
import gestorAplicacion.DatosTeatro;

public class NewUser extends OpcionDeMenu {
	

	
	@Override
	public void ejecutar() {
		if(!DatosTeatro.Datos.isEmpty()) {
			SaveObject.Write(SaveObject.U_Cli, DatosTeatro.Datos);
			DatosTeatro.U.add(new Cliente((String) DatosTeatro.Datos.get(0),(String)DatosTeatro.Datos.get(1),
					(String)DatosTeatro.Datos.get(2),(String)DatosTeatro.Datos.get(3),(String)DatosTeatro.Datos.get(4),
					(Integer)DatosTeatro.Datos.get(5)));
		}
		//do {
		//	System.out.println("Presione 1: Para crear nueva cuenta");
		//	op=in.nextInt();
		//	if(op!=1 && op!=2) {
		//		System.out.println("¡¡ERROR: LA OPCIÓN NO ESTÁ DISPONIBLE!!");
		//	}
		//}while(op!=1 && op!=2);
		//	(DatosTeatro.U).add(new Cliente().crearUser(op));
	}
	

		
	@Override
	public String mostrar() {
		return "Registrarse";
	}
	
}
