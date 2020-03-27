package gui.Fun.oidor;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ActionInfoTicket implements EventHandler<ActionEvent>{

	public void handle(ActionEvent E) {
		String dat3 = ((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).getText();
		
		
		if(!dat3.equals("")||dat3==null) {
			
			int cod = Integer.parseInt(dat3);
			Cliente user = (Cliente)DatosTeatro.userLive;
			Tiquete tiq = user.getTiqueteWithCodigo(cod);
			Pago pago = tiq.getRefPago();
			
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Tiquete N°: "+cod);
			a.setHeaderText("TIQUETE...");
			a.setContentText("Codigo del pago: "+ pago.getCodigo()+"\n"+
			"Funcion: "+tiq.getEvento().verPelicula()+"\n"+"Asiento: "+tiq.getAsiento().getCodigo()+"\n"+
					"Valor del tiquete: " + pago.getCostoTiquete()+"\n"+
					"Valor total (iva incluido): " + pago.getCostoTotal());
			a.showAndWait();
		}else {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("CodeError");
			a.setHeaderText("Seleccione el codigo del tiquete");
			a.showAndWait();
		}
	}

}
