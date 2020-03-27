package gui.Fun;

import gui.Ini;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionMenuFuncion;
import gui.Fun.oidor.ActionSetEvent;
import gui.Fun.oidor.RBack;
import gui.Fun.oidor.ShowInfo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uiMain.menuconsola.CambiarAsiento;
import uiMain.menuconsola.EscogerEvento;
import uiMain.menuconsola.PagarTiquete;
import uiMain.menuconsola.RecargarTarjetad;
import uiMain.menuconsola.Reembolso;

public class Funcional{
	
	private static Scene s2;
	public static Scene getScene2() {
		return s2;
	}
	
	private static VBox P2= new VBox();
	public static VBox getP2() {
		return P2;
	}
	
	//Segunda parte
	public static void setScene() {
		Ini.getVent().setTitle("TEATROS SA");
		
		//Nombre de la aplicacion
		VBox P0 = new VBox();
		P0.setPadding(new Insets(15,15,15,15));
		P0.setAlignment(Pos.TOP_CENTER);
		Label NA = new Label("Teatros SA");
		NA.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		NA.setTextFill(Color.PURPLE);
		NA.setTextAlignment(TextAlignment.CENTER);
		P0.getChildren().add(NA);
		
		//Menu de opciones ARCHIVO, FUNCIONALIDADES, HELP
		BorderPane P1 = new BorderPane();
		
		MenuBar Princ = new  MenuBar();
		Menu Marc = new Menu("Archivo");
		Menu MF = new Menu("Procesos y consultas");
		Menu H = new Menu("Ayuda");
		
		MenuItem nomApp = new MenuItem("App Teatro SA");
		MenuItem S = new MenuItem("Salir");
		RBack R = new RBack();
		S.setOnAction(R);
		Marc.getItems().add(nomApp);
		Marc.getItems().add(S);
		
		MenuItem info = new MenuItem("Acerca de");
		ShowInfo Aler = new ShowInfo();
		info.setOnAction(Aler);
		H.getItems().add(info);
		
		MenuItem escogerEvento = new MenuItem((new EscogerEvento()).mostrar());
		MenuItem pagarTiq = new MenuItem((new PagarTiquete()).mostrar());
		MenuItem reembolso = new MenuItem((new Reembolso()).mostrar());
		MenuItem cambiarAsiento = new MenuItem((new CambiarAsiento()).mostrar());
		MenuItem recargarTarj = new MenuItem((new RecargarTarjetad()).mostrar());
		MF.getItems().addAll(escogerEvento,pagarTiq,reembolso,cambiarAsiento,recargarTarj);
		
		ActionMenuFuncion M0 = new ActionMenuFuncion();
		escogerEvento.setOnAction(M0);
		pagarTiq.setOnAction(M0);
		reembolso.setOnAction(M0);
		cambiarAsiento.setOnAction(M0);
		recargarTarj.setOnAction(M0);
		
		/*HBox Botons = new HBox();
		
		Button Acep = new Button("Aceptar");
		Acep.setAlignment(Pos.CENTER_LEFT);
		Acep.setStyle("-fx-background-color: blue;");
		Acep.setTextFill(Color.FLORALWHITE);
		Botons.getChildren().add(Acep);
		
		Button Delet = new Button("Borrar");
		Delet.setTextFill(Color.FLORALWHITE);
		Delet.setAlignment(Pos.CENTER_RIGHT);
		Delet.setStyle("-fx-background-color: red;");
		Botons.getChildren().add(Delet);
		Botons.setAlignment(Pos.CENTER);
		Botons.setSpacing(15);
		
		ActionDelete M21 = new ActionDelete();
		Delet.setOnAction(M21);
		
		ActionSetEvent M22 = new ActionSetEvent();
		Acep.setOnAction(M22);
		
		P2.getChildren().add(Botons);*/
		
		Princ.getMenus().addAll(Marc,MF,H);
		
		P1.setPadding(new Insets(15,15,15,15));
		P1.setTop(Princ);
		
		P2.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		P2.setPadding(new Insets(15,15,15,15));
		P2.setSpacing(10);
		
		P1.setCenter(P2);
		
		
		P0.getChildren().add(P1);	
		
		
		Scene s2 = new Scene(P0,950,700);
		Ini.getVent().setScene(s2);
	}
	
	

}
