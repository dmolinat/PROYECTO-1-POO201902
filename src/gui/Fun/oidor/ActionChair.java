package gui.Fun.oidor;

import gui.Fun.FieldPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ActionChair implements EventHandler<ActionEvent>{

	public void handle(ActionEvent B) {
		Object b = B.getSource();
		
		String cod = ((Button) b).getText();
		((TextField) FieldPanel.getNodeByRowColumnIndex(4, 1, FieldPanel.getSoporte())).setText(cod);
		TableroAsientos.getTablero().close();
	}

}
