package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionMoney;
import gui.Fun.oidor.ActionReembolsoEvent;
import gui.Fun.oidor.ActionReloadTarjet;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import gestorAplicacion.DatosTeatro;

public class RecargarTarjetad extends OpcionDeMenu{
	private static FieldPanel tarjet;
	public static FieldPanel getTarjet() {
		return tarjet;
	}
	
	@Override
	public void ejecutar() {
		
		//NegativeNumberException
		//TarjetaDesOutException
		
		Funcional.getP2().getChildren().clear();
		
		Label nameFun = new Label((mostrar()));
		nameFun.setFont(new Font("Times New Roma",20));
		nameFun.setTextFill(Color.GRAY);
		nameFun.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(nameFun);
		
		Label descripF = new Label("Esta funcion le permite recargar saldo a su tarjeta\n"
				+"1. Digite el valor que desea recargar (solo numeros)\n"+
				"2. Presione aceptar para efectuar la operacion");
		descripF.setFont(new Font("Times New Roma",20));
		descripF.setTextFill(Color.GRAY);
		descripF.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.DOTTED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(descripF);
		
		FieldPanel.getSoporte().getChildren().clear();
		tarjet = new FieldPanel("Data_TarjetaDes",new String[] {"Valor"},"Recarga",null,new Boolean[] {true});
		Funcional.getP2().getChildren().add(FieldPanel.getSoporte());
		
		HBox Botons = new HBox();
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
		
		ActionDelete M21 = new ActionDelete(tarjet);
		Delet.setOnAction(M21);
		
		ActionReloadTarjet M22 = new ActionReloadTarjet();
		Acep.setOnAction(M22);		
		Funcional.getP2().getChildren().add(Botons);
		
		Button saldo = new Button("SALDO ACTUAL");
		FieldPanel.getSoporte().add(saldo, 2, 1);
		ActionMoney M69 = new ActionMoney();
		saldo.setOnAction(M69);
		
		FieldPanel.getSoporte().setAlignment(Pos.CENTER);
		Funcional.getP2().setAlignment(Pos.CENTER);
		
		/*Scanner in = new Scanner(System.in);
		
		
		System.out.println("Su saldo es de: "+((Cliente)DatosTeatro.userLive).getAfiliacion().getValorRecargado());
		
		
		
		double op=-1.0;
		do{
			System.out.println("¿Cuánto es el monto que desea mandar?");
			op=in.nextDouble();	
			if(op<0) {
				System.out.println("AVISO: El monto seleccionado no se puede recargar");
			}
		}while(op<0);
		
		((Cliente)DatosTeatro.userLive).RecargarTarjeta(op);
		
		System.out.println("Su nuevo saldo es de: "+((Cliente)DatosTeatro.userLive).getAfiliacion().getValorRecargado());*/
		
		
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Recargar tarjeta: ";
	}

}
