package gui.Fun.oidor;

import java.util.ArrayList;

import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gui.Fun.FieldPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddDatTextFieldHorario implements EventHandler<ActionEvent>{

	public void handle(ActionEvent E) {
		Object item = E.getSource();
		String date = (String) ((ComboBox)item).getValue();
		
		((TextField) FieldPanel.getNodeByRowColumnIndex(3, 1, FieldPanel.getSoporte())).setText(date);
		
		if(date!=null) {
			String nam = ((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).getText();
			int numSala = Pelicula.getSalaWithNameAndDate(nam, date);
			String xNumSala = Integer.toString(numSala); 
			
			((TextField) FieldPanel.getNodeByRowColumnIndex(2, 1, FieldPanel.getSoporte())).setText(xNumSala);
			
			if(!(((TextField) FieldPanel.getNodeByRowColumnIndex(2, 1, FieldPanel.getSoporte())).getText()==null)) {
				Button Asientos = new Button ("...Seleccione su asiento...");
				TableroAsientos M19 = new TableroAsientos();
				Asientos.setOnAction(M19);
				FieldPanel.getSoporte().add(Asientos, 2, 4);
				Asientos.setPrefWidth(250);
				
			}
		}else {
			((TextField) FieldPanel.getNodeByRowColumnIndex(3, 1, FieldPanel.getSoporte())).setText("");
		}
			
		
				
	}

}
