package gui.Fun.oidor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.Sala;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.errorApp.ErrorAplicacionException;
import gui.errorApp.WrongSetEventException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import uiMain.menuconsola.EscogerEvento;

public class ActionSetEvent implements EventHandler<ActionEvent> {
	
	public void handle(ActionEvent event){
		
		try {
			//Funcional.getP2().getChildren().clear();			
			String Pel = EscogerEvento.getData().getValue("Pelicula");
			String Sala = EscogerEvento.getData().getValue("Sala");
			String Hora = EscogerEvento.getData().getValue("Horario");
			String codAsi = EscogerEvento.getData().getValue("Asiento");
			
			if(Pel.equals("") || codAsi.equals("") || Sala.equals("") || Hora.equals("")) {
				throw new WrongSetEventException(EscogerEvento.getData()); 
			}
			
			
			if(Funcional.getP2().getChildren().size()>4) {
				Funcional.getP2().getChildren().remove(Funcional.getP2().getChildren().size()-1);
			}
			
			//Resultados
			VBox Res = new VBox();
			Cliente usuario= (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
	        
			Label Tit = new Label("...RESULTADO...");
			Tit.setFont(new Font("Times New Roman",20));
			Tit.setTextFill(Color.DARKBLUE);
			Tit.setTextAlignment(TextAlignment.CENTER);
			Tit.setAlignment(Pos.CENTER);
			
			Res.getChildren().add(Tit);

			
			Tit.setAlignment(Pos.CENTER);
			
			
			//Donde se ingresaran los datos del tiquete
			HBox tiq = new HBox();
			
			//Obtener Funcion
	        Pelicula Peli = Pelicula.getPeliWithName(Pel);      
	        ArrayList<Funcion> Pf = Peli.getFuncions();
	        String d = Hora.substring(7);
	        d=d.trim();
	        
	        Funcion f1 = null;
	        for(int i=0;i<Pf.size();i++) {
	        	f1 = Pf.get(i);
	        	String x = ""+f1.getFecha1();
	        	x=x.trim();

	        	if(x.equals(d.trim())){
	        		break;
	        	}
	        }
	        
	    
	        Tiquete tiquete = new Tiquete();
	        tiquete.setEvento(f1); //se le asigna la funcion escogida
	        
	        String codigoAsiento = codAsi;
			Asiento asiento = f1.buscarAsiento(codigoAsiento);
			boolean escoger = tiquete.escogerAsiento(asiento);
			if (escoger == true) {
				ArrayList<Object> arc = new ArrayList();
					int costo = asiento.getPrecio();
					Pago pago = new Pago(costo, false, tiquete);
					arc.add(pago);
					tiquete.setRefPago(pago);
					pago.setCostoTotal(costo);
					tiquete.setEvento(f1);
					tiquete.setCliente(usuario);
					ArrayList<Tiquete> aux = usuario.getTiquetes();
					aux.add(tiquete);
					usuario.setTiquetes(aux);
					
					
					
					Label l2 = new Label("TIQUETE GENERADO EXITOSAMENTE");
					l2.setFont(new Font("Times New Roman",14));
					l2.setTextFill(Color.DARKBLUE);
					l2.setTextAlignment(TextAlignment.CENTER);
					l2.setAlignment(Pos.CENTER);
					Res.getChildren().add(l2);
					
					tiquete.setCodigo(Tiquete.setGenCodigo());
					int cod = tiquete.getCodigo();
					Label l3 = new Label("CODIGO DEL "
							+ "\nTIQUETE GENERADO: "+Integer.toString(cod));
					l3.setFont(new Font("Times New Roman",20));
					l3.setTextFill(Color.DARKGREEN);
					l3.setTextAlignment(TextAlignment.CENTER);
					
					tiq.getChildren().add(l3);
					
					Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\ImTiq.png"));
					ImageView ImT1= new ImageView(image2);
					ImT1.setFitHeight(150);
					ImT1.setFitWidth(150);
					tiq.getChildren().add(ImT1);
					tiq.setSpacing(30);
					tiq.setAlignment(Pos.CENTER);
					
					Res.setSpacing(15);
					Res.getChildren().add(tiq);
					Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
					Res.setStyle("-fx-background-color: goldenrod;");
					
					Funcional.getP2().getChildren().add(Res);
					
			}
				
		}catch(WrongSetEventException e) {
			ErrorAplicacionException.getWarning().showAndWait();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}

}
