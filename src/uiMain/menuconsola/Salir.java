package uiMain.menuconsola;

import java.util.Optional;

import gui.Ini;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import uiMain.Start;

public class Salir extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		Ini.getAlertA().setAlertType(AlertType.CONFIRMATION);
		Ini.getAlertA().setTitle(mostrar());
		Ini.getAlertA().setHeaderText("¿Estas seguro que deseas salir?");
		
		Optional<ButtonType> result = Ini.getAlertA().showAndWait();
		if (!(result.get() == ButtonType.CANCEL)){
		    System.exit(0);
		} else {
		}
	}

	@Override
	public String mostrar() {
		return "Salir";
	}
}
