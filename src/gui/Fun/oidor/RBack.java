package gui.Fun.oidor;
import gui.Ini;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RBack implements EventHandler<ActionEvent> {	
	public void handle(ActionEvent E) {
		Ini.getVent().setScene(Ini.getScene1());	
	}

}
