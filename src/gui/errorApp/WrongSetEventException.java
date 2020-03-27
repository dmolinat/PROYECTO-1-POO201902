package gui.errorApp;

import gui.Fun.FieldPanel;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import uiMain.menuconsola.EscogerEvento;

public class WrongSetEventException extends WrongValueException {
	private FieldPanel campos = new FieldPanel();
	public WrongSetEventException(FieldPanel campos) {
		String x="Falta el campo: ";
			if(EscogerEvento.getData().getValue("Pelicula").equals("")) {
				x=x.concat("- Pelicula -");
			}
			if(EscogerEvento.getData().getValue("Sala").equals("")) {
				x=x.concat("- Sala -");
			}
			if(EscogerEvento.getData().getValue("Horario").equals("")) {
				x=x.concat("- Horario -");
			}
			if(EscogerEvento.getData().getValue("Asiento").equals("")) {
				x=x.concat("- Asiento -");
			}
			
		ErrorAplicacionException.getWarning().setContentText(x);
		
		
	}
	
}
