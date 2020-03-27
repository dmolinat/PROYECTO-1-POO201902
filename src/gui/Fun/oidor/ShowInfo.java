package gui.Fun.oidor;
import gui.Ini;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowInfo implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent E) {
		Alert A = new Alert(AlertType.INFORMATION);
		A.setTitle("ACERCA DE:");
		A.setHeaderText("...Autores de la App...");
		A.setContentText("'DENILSON ANDRES MOLINA TRUYOT\n"
				+ "WILMAR ANDRES GARCIA BEDOYA\n"
				+ "SANTIAGO CANO VASQUES\n"
				+ "KEITH DAVID KELSY DIAZ'");
		A.showAndWait();
	}

}