package gui.Fun.oidor;

import gestorAplicacion.Pelicula;
import gui.Fun.FieldPanel;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import uiMain.menuconsola.EscogerEvento;

public class ShowInfoMovie implements EventHandler<ActionEvent>{
	public void handle(ActionEvent E) {
		String val = EscogerEvento.getData().getValue("Pelicula");
		Alert a = new Alert(AlertType.NONE);
		if(val.equals("")||val==null) {
			a.setAlertType(AlertType.WARNING);
			a.setTitle("AVISO");
			a.setHeaderText("No ha seleccionado una pelicula");
			a.setContentText("Selecione una pelicula para ver sus detalles");
			a.showAndWait();
		}else {
			a.setAlertType(AlertType.INFORMATION);
			a.setTitle(val);
			Pelicula pel = Pelicula.getPeliWithName(val);
			a.setHeaderText("Datos de la Pelicula: ");
			a.setContentText("Nombre: "+pel.getNombre()+"\n"+"Genero: "+pel.getGenero()+"\nAño de lanzamiento: "
						+ pel.getAñoLanzamiento()+"\nDirector: "+pel.getDirector());
			a.showAndWait();
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
}
