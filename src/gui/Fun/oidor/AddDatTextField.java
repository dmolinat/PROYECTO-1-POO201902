package gui.Fun.oidor;

import java.util.ArrayList;

import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gui.Fun.FieldPanel;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import uiMain.menuconsola.EscogerEvento;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class AddDatTextField implements EventHandler<ActionEvent>{

	public void handle(ActionEvent E) {
		Object item = E.getSource();
		String text = (String) ((ComboBox)item).getValue();
		
		((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).setText(text);
		
		//Horario
		EscogerEvento.getCHor().getItems().clear();
		EscogerEvento.getCHor().setPromptText("HORARIO:");
		Pelicula P = Pelicula.getPeliWithName(text);
		for(int j=0;j<3;j++) {
			EscogerEvento.getCHor().getItems().add(P.getFecha(j));
		}		
		AddDatTextFieldHorario menHor = new AddDatTextFieldHorario();
		EscogerEvento.getCHor().setOnAction(menHor);
		
		//Sala
		((TextField) FieldPanel.getNodeByRowColumnIndex(2, 1, FieldPanel.getSoporte())).setText("");
		
		
	}

}
