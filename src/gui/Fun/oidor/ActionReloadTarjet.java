package gui.Fun.oidor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.users.Cliente;
import gui.Fun.Funcional;
import gui.errorApp.ErrorAplicacionException;
import gui.errorApp.NegativeValueException;
import gui.errorApp.NotNumericException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import uiMain.menuconsola.RecargarTarjetad;

public class ActionReloadTarjet implements EventHandler<ActionEvent>{

	public void handle(ActionEvent E) {
		Cliente usuario = (Cliente) DatosTeatro.userLive;
		
		Tarjeta_des tarjeta = usuario.getAfiliacion();
		String dat = RecargarTarjetad.getTarjet().getValue("Valor");
		
		if(Funcional.getP2().getChildren().size()>4) {
			Funcional.getP2().getChildren().remove(Funcional.getP2().getChildren().size()-1);
		}
		
		if(!(dat.equals("")||dat==null)) {
			try {
				if(isNumeric(dat)) {
					try {
						int numTarj = Integer.parseInt(dat);
						if(numTarj>=0) {
							VBox Res = new VBox();
							Label Tit = new Label("...RESULTADO...");
							Tit.setFont(new Font("Times New Roman",20));
							Tit.setTextFill(Color.DARKBLUE);
							Tit.setTextAlignment(TextAlignment.CENTER);
							Tit.setAlignment(Pos.CENTER);
							Res.getChildren().add(Tit);
							
							HBox Reemb = new HBox();
							Label l2 = new Label("RECARGA EXITOSA");
							l2.setFont(new Font("Times New Roman",14));
							l2.setTextFill(Color.DARKBLUE);
							l2.setTextAlignment(TextAlignment.CENTER);
							l2.setAlignment(Pos.CENTER);
							Res.getChildren().add(l2);
				
							usuario.RecargarTarjeta(numTarj);
							
							Label l3 = new Label("La recarga de:--> "
									+ numTarj+" <--\nSE HA REALIZADO CORRECTAMENTE.\n"
											+ "NUEVO SALDO: "+tarjeta.getValorRecargado());
							l3.setFont(new Font("Times New Roman",20));
							l3.setTextFill(Color.DARKGREEN);
							l3.setTextAlignment(TextAlignment.CENTER);
							Reemb.getChildren().add(l3);
							
							Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\Cc.png"));
							ImageView ImT1= new ImageView(image2);
							ImT1.setFitHeight(150);
							ImT1.setFitWidth(150);
							Reemb.getChildren().add(ImT1);
							Reemb.setSpacing(30);
							Reemb.setAlignment(Pos.CENTER);
							
							Res.setSpacing(15);
							Res.getChildren().add(Reemb);
							Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
							Res.setStyle("-fx-background-color: lightskyblue;");
							
							Funcional.getP2().getChildren().add(Res);
						}else {
							throw new NegativeValueException();
						}
				
					}catch(NegativeValueException e) {
						ErrorAplicacionException.getWarning().showAndWait();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					throw new NotNumericException();
				}
			}catch(NotNumericException e) {
				ErrorAplicacionException.getWarning().showAndWait();
			}
		}
		
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
	
	private boolean isNumeric(String numTarj)   {
		try {
			Integer x = Integer.parseInt(numTarj);
		}catch (NumberFormatException e) {
			return false;
		}	
		return true;
	}

}
