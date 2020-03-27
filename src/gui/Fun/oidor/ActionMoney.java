package gui.Fun.oidor;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.users.Cliente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ActionMoney implements EventHandler<ActionEvent> {

	public void handle(ActionEvent E) {
		Cliente user = (Cliente) DatosTeatro.userLive;
		Tarjeta_des tarjeta = user.getAfiliacion();
		
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Tarjerta Des: "+tarjeta.getCodigo());
		a.setHeaderText("SALDO: "+tarjeta.getValorRecargado());
		a.setContentText("Datos de la tarjeta: \n"+
		"Cliente: "+ user.getDocument()+"\n"+
				"Fecha Expedicion: "+tarjeta.getFechaExp()+"\n"+
				"Fecha Vencimiento: "+tarjeta.getFechaVen());
		a.showAndWait();
	}

}
