package uiMain.menuconsola;

import gui.Ini;
import javafx.scene.text.Font;

public class Descripcion extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		Ini.getLD().setText("'La aplicación ofrece una serie de herramientas\n"
				+ "para el uso cómodo del usuario que ingrese. En él podrá realizar\n"
				+ "las operaciones necesarias para lograr obtener un tiquete a alguna\n"
				+ "función del usuario de forma satisfactoria. Desde escoger el evento\n"
				+ "con su asiento respectivo, hasta abstenerse de ir con nuestro control\n"
				+ "de reembolsos.'");
		
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Descripcion";
	}

}
