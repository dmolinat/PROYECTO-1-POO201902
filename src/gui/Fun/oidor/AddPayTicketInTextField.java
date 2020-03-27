package gui.Fun.oidor;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddPayTicketInTextField implements EventHandler<ActionEvent>{
	
	public void handle(ActionEvent E) {
		
		Object dat = E.getSource();
		String dat1 = (String) ( (ComboBox) dat).getValue();
		((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).setText(dat1);
		
		Button verMas = ((Button) FieldPanel.getNodeByRowColumnIndex(1, 3, FieldPanel.getSoporte()));
		ActionInfoTicket M24 = new ActionInfoTicket();
		verMas.setOnAction(M24);
		
		/*int cod = Integer.parseInt(dat1);
		Cliente usuario = (Cliente) DatosTeatro.userLive;
		Tiquete tiquete=null;	
		tiquete = usuario.seleccionarTiquete(cod);
		Pago pago = tiquete.getRefPago();
		Tarjeta_des tarjeta = usuario.getAfiliacion();
				
		boolean transaccion = pago.transaccion(tarjeta);
		if (transaccion == true) {
			
			VBox Res = new VBox();
			Label Tit = new Label("...RESULTADO...");
			Tit.setFont(new Font("Times New Roman",20));
			Tit.setTextFill(Color.DARKBLUE);
			Tit.setTextAlignment(TextAlignment.CENTER);
			Tit.setAlignment(Pos.CENTER);
			
			Res.getChildren().add(Tit);
			
			HBox tiq = new HBox();
			Label l2 = new Label("TRANSACCION EXITOSA");
			l2.setFont(new Font("Times New Roman",14));
			l2.setTextFill(Color.DARKBLUE);
			l2.setTextAlignment(TextAlignment.CENTER);
			l2.setAlignment(Pos.CENTER);
			
			Res.getChildren().add(l2);
			
			
			Label l3 = new Label("Resumen de la transaccion: \n"
					+ "Codigo del pago: "+ pago.getCodigo()+"\n"+
					"Valor del tiquete: " + pago.getCostoTiquete()+"\n"+
					"Valor total (iva incluido): " + pago.getCostoTotal());
			l3.setFont(new Font("Times New Roman",20));
			l3.setTextFill(Color.DARKGREEN);
			l3.setTextAlignment(TextAlignment.CENTER);
			tiq.getChildren().add(l3);
			
			Image image2 = new Image(getClass().getResourceAsStream("/imagenes/Check.png"));
			ImageView ImT1= new ImageView(image2);
			ImT1.setFitHeight(150);
			ImT1.setFitWidth(150);
			tiq.getChildren().add(ImT1);
			tiq.setSpacing(30);
			tiq.setAlignment(Pos.CENTER);
			
			Res.setSpacing(15);
			Res.getChildren().add(tiq);
			Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			Res.setStyle("-fx-background-color: white;");
			
			Funcional.getP2().getChildren().add(Res);
			
			System.out.println("Transaccion exitosa");
			System.out.println("Resumen de la transaccion: ");
			System.out.println("Codigo del pago: " + pago.getCodigo());
			System.out.println("Valor del tiquete: " + pago.getCostoTiquete());
			System.out.println("Valor total (iva incluido): " + pago.getCostoTotal());
			
		}else {
			//MoneyGetOutOfRangeException
			//System.out.println("No tienes saldo suficiente");
		}*/
		
	}

}
