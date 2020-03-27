package gui.Fun.oidor;

import gui.Fun.FieldPanel;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddPayWithChairEvent implements EventHandler<ActionEvent> {
	public void handle(ActionEvent E) {
		// TODO Auto-generated method stub
		Object dat = E.getSource();
		String dat1 = (String) ( (ComboBox) dat).getValue();
		((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).setText(dat1);
		
		Button verMas = ((Button) FieldPanel.getNodeByRowColumnIndex(1, 3, FieldPanel.getSoporte()));
		ActionInfoTicket M24 = new ActionInfoTicket();
		verMas.setOnAction(M24);
		
		if(!(((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).getText()==null)) {
			Button Asientos = new Button ("...Seleccione su asiento...");
			TabletChangeChairEvent M19 = new TabletChangeChairEvent();
			Asientos.setOnAction(M19);
			FieldPanel.getSoporte().add(Asientos, 2, 2);
			Asientos.setPrefWidth(250);
		}
	}
	
}
