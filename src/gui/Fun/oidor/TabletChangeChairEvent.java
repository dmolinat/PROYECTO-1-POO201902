package gui.Fun.oidor;
import java.util.ArrayList;
import java.util.Arrays;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TabletChangeChairEvent implements EventHandler<ActionEvent> {
	
	GridPane chair = new GridPane();
	private static Stage tablero;
	
	public static Stage getTable() {
		return tablero;
	}
	
	public void handle(ActionEvent E) {
		VBox tabla = new VBox();
		Scene m1;
		tabla.getChildren().clear();
		chair.getChildren().clear();
		
		tabla.setPadding(new Insets(20,20,20,20));
		
		Label l1 = new Label("Escoja su Asiento");
		l1.setFont(new Font("Times New Roman",25));
		l1.setTextFill(Color.BLACK);
		l1.setAlignment(Pos.TOP_CENTER);
		tabla.getChildren().add(l1);
		
		tabla.setAlignment(Pos.CENTER);
		
		Label l2 = new Label("Los precios de los asientos son: \n"
				+ "Para asientos empezados por A y B: 10000\n"
				+ "Asientos comunes: 5000.\n");
		l2.setFont(new Font("Times New Roman",18));
		l2.setTextFill(Color.DARKBLUE);
		l2.setAlignment(Pos.CENTER);
		tabla.getChildren().add(l2);
		
		//ArrayList<String> privados = new ArrayList<String>(Arrays.asList("A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"));
    	//ArrayList<String> comunes = new ArrayList<String>(Arrays.asList("C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "G0", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "H0", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9"));
    	
		String dat = ((TextField) FieldPanel.getNodeByRowColumnIndex(1, 1, FieldPanel.getSoporte())).getText();
		
		if(!(dat.equals("")||dat==null)) {
			
		int cod = Integer.parseInt(dat);
		Cliente user = (Cliente) DatosTeatro.userLive;
		Tiquete ticket = user.getTiqueteWithCodigo(cod);
		Funcion fun = ticket.getEvento();
		
			ArrayList<Asiento> LChair = fun.getAsientos();
			int j=0;
			int k=0;
			int con=0;
			
			AddChairInTextField M20 = new AddChairInTextField();
			
	    	for(int i=0;i<LChair.size();i++) {
	    		Asiento x = LChair.get(i);
	    		if(con==80) {
	    			break;
	    		}
	    		if(x.isDisponible()) {
	    			Button c = new Button(x.getCodigo());
	    			c.setPrefWidth(80);
	    			c.setStyle("-fx-background-color: green;");
	    			c.setTextFill(Color.FLORALWHITE);
	    			c.setOnAction(M20);
	    			chair.add(c, k, j);
	    			k++;
	    			con++;
	    		}else {
	    			Button c = new Button(x.getCodigo());
	    			c.setPrefWidth(80);
	    			c.setOnAction(M20);
	    			c.setStyle("-fx-background-color: red;");
	    			c.setTextFill(Color.FLORALWHITE);
	    			chair.add(c, k, j);
	    			k++;
	    			con++;
	    		}
	    		if(k!=0 && (k)%10==0) {
	    			k=0;
	    			j++;
	    		}
	    	}
	    	
	    	chair.setPadding(new Insets(10,10,10,10));
	    	chair.setHgap(10);
	    	chair.setVgap(10);
	    	chair.setAlignment(Pos.CENTER);
	    	
	    	tabla.getChildren().add(chair);
	    	
			tablero = new Stage();
			
			m1 = new Scene(tabla,500,500);
			tablero.setTitle("ASIENTOS");
			tablero.setScene(m1);
			tablero.show();
		}else {
			//ChairWithOutFuntionException
		}
		
	}

}