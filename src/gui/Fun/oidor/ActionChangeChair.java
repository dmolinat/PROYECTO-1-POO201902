package gui.Fun.oidor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import uiMain.menuconsola.CambiarAsiento;

public class ActionChangeChair implements EventHandler<ActionEvent> {

	public void handle(ActionEvent E) {
		String dat1 = CambiarAsiento.getcampoSetChair().getValue("Codigo");
		String codAsiento = CambiarAsiento.getcampoSetChair().getValue("Asiento");
		
		if(Funcional.getP2().getChildren().size()>4) {
			Funcional.getP2().getChildren().remove(Funcional.getP2().getChildren().size()-1);
		}
		
		Tiquete tiquete=null;
		if(!(dat1.equals("")||dat1==null||codAsiento.equals("")||codAsiento==null)) {
			int codTiquete = Integer.parseInt(dat1);
			Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
			
			tiquete = usuario.getTiqueteWithCodigo(codTiquete);
			Funcion funcion = tiquete.getEvento();
			Asiento asiento = funcion.buscarAsiento(codAsiento);
			
			boolean cambiar = tiquete.cambiarAsiento(asiento);
			if (cambiar == true) {
				VBox Res = new VBox();
				Label Tit = new Label("...RESULTADO...");
				Tit.setFont(new Font("Times New Roman",20));
				Tit.setTextFill(Color.DARKBLUE);
				Tit.setTextAlignment(TextAlignment.CENTER);
				Tit.setAlignment(Pos.CENTER);
				Res.getChildren().add(Tit);
				
				HBox Reemb = new HBox();
				Label l2 = new Label("ASIENTO CAMBIADO CORRECTAMENTE EXITOSO");
				l2.setFont(new Font("Times New Roman",14));
				l2.setTextFill(Color.DARKBLUE);
				l2.setTextAlignment(TextAlignment.CENTER);
				l2.setAlignment(Pos.CENTER);
				Res.getChildren().add(l2);
				
				Label l3 = new Label("El Asiento de la funcion: "
						+ funcion.verPelicula()+" \nSE HA CAMBIADO.\n"
								+ "ASIENTO ASIGNADO: "+asiento.getCodigo());
				l3.setFont(new Font("Times New Roman",20));
				l3.setTextFill(Color.DARKGREEN);
				l3.setTextAlignment(TextAlignment.CENTER);
				Reemb.getChildren().add(l3);
				
				
				Image image2;
				try {
					image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\setAsiento.png"));
					ImageView ImT1= new ImageView(image2);
					ImT1.setFitHeight(150);
					ImT1.setFitWidth(150);
					Reemb.getChildren().add(ImT1);
					Reemb.setSpacing(30);
					Reemb.setAlignment(Pos.CENTER);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Res.setSpacing(15);
				Res.getChildren().add(Reemb);
				Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				Res.setStyle("-fx-background-color: lavenderblush;");
				
				Funcional.getP2().getChildren().add(Res);

				//System.out.println("Asiento cambiado correctamente");
			}
			else {
				VBox Res = new VBox();
				Label Tit = new Label("...RESULTADO...");
				Tit.setFont(new Font("Times New Roman",20));
				Tit.setTextFill(Color.DARKBLUE);
				Tit.setTextAlignment(TextAlignment.CENTER);
				Tit.setAlignment(Pos.CENTER);
				Res.getChildren().add(Tit);
				
				HBox Reemb = new HBox();
				Label l2 = new Label("ASIENTO NO CAMBIADO");
				l2.setFont(new Font("Times New Roman",14));
				l2.setTextFill(Color.DARKBLUE);
				l2.setTextAlignment(TextAlignment.CENTER);
				l2.setAlignment(Pos.CENTER);
				Res.getChildren().add(l2);
				
				Label l3 = new Label("El Asiento de la funcion: "
						+ funcion.verPelicula()+" \nNO SE HA CAMBIADO.\n"
								+ "Sug: Puede ser porque el evento ya paso\n"
								+ "o el asiento NO se encuentra disponible.");
				l3.setFont(new Font("Times New Roman",20));
				l3.setTextFill(Color.DARKGREEN);
				l3.setTextAlignment(TextAlignment.CENTER);
				Reemb.getChildren().add(l3);
				
				try {
					Image image2 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\AsientoS.png"));
					ImageView ImT1= new ImageView(image2);
					ImT1.setFitHeight(150);
					ImT1.setFitWidth(150);
					Reemb.getChildren().add(ImT1);
					Reemb.setSpacing(30);
					Reemb.setAlignment(Pos.CENTER);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Res.setSpacing(15);
				Res.getChildren().add(Reemb);
				Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				Res.setStyle("-fx-background-color: salmon;");
				
				Funcional.getP2().getChildren().add(Res);
				//System.out.println("El asiento no esta disponible, o el evento ya paso");
			}
		}else {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("AVISO");
			a.setHeaderText("NO se ha efectuado el cambio del asiento");
			a.setContentText("Seleccione el asiento deseado.");
			a.showAndWait();
			//Aviso
		}
		
		
/*Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
		System.out.println("Lista de sus tiquetes: ");
		usuario.mostrarTiquetesSinPagar();
		
		if (usuario.getTiquetes().isEmpty()) {
			System.out.println("No tiene tiquetes asignados");
			return;
		}else {
			System.out.println("Digite el numero de la lista, correspondiente al tiquete al cual desea cambiar el asiento");
			
			Tiquete tiquete = null;
			do {
				int numero = sc.nextInt();
				tiquete = usuario.seleccionarTiquete(numero);
				if(tiquete==null) {
					System.out.println("AVISO: Tiquete no disponible");
				}
			}while(tiquete==null);
			
			
			
			
			System.out.println("Lista de asientos disponibles: ");
			Funcion funcion = tiquete.getEvento();
			boolean verAsientos = funcion.verAsientosDisponibles();
			
			if (verAsientos == false) {
				System.out.println("No hay asientos disponibles");
				return;
			}
			
			System.out.println("Por favor, escriba el codigo del asiento deseado");
			System.out.println("El codigo debe tener la siguiente estructura: una letra al inicio (A-H) y un numero al final (0 al 9)");
			System.out.println("Ejemplos: A0, B6, H9");
			System.out.println("Asientos que empiezan por A y B son privados, tienen un costo de 10.000");
			System.out.println("Los demas asientos son comunes, tienen un valor de 5.000");
			
			String codigoAsiento = sc.next();
			Asiento asiento = funcion.buscarAsiento(codigoAsiento);
			
			if (asiento == null) {
				System.out.println("Codigo de asiento invalido");
				return;
			}
			else {
				boolean cambiar = tiquete.cambiarAsiento(asiento);
				if (cambiar == true) {
					System.out.println("Asiento cambiado correctamente");
				}
				else {
					System.out.println("El asiento no esta disponible, o el evento ya paso");
					return;
				}
			}

		}*/

		
	}

}
