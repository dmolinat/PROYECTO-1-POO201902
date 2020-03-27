package gui.errorApp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorAplicacionException extends Exception{
	private static Alert warning = new Alert(AlertType.WARNING);
	
	public ErrorAplicacionException() {
		warning.setTitle("Manejo de errores de la aplicacion:");;
	}
	
	public static Alert getWarning() {
		 return warning;
	}
}
