package gui.Fun.oidor;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.Funcional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
import uiMain.menuconsola.PagarTiquete;

public class ActionReembolsoEvent implements EventHandler<ActionEvent> {

	public void handle(ActionEvent E) {		
		Alert a = new Alert(AlertType.NONE);
		
		String dat1 = PagarTiquete.getT().getValue("Codigo");
		
		if(Funcional.getP2().getChildren().size()>4) {
			Funcional.getP2().getChildren().remove(Funcional.getP2().getChildren().size()-1);
		}
		
		if(!(dat1.equals("")||dat1==null)) {
			int cod = Integer.parseInt(dat1);
			Cliente usuario = (Cliente) DatosTeatro.userLive;
			
			Tiquete tiquete=null;
			tiquete=usuario.getTiqueteWithCodigo(cod);
			Pago pago = tiquete.getRefPago();
			Tarjeta_des tarjeta = usuario.getAfiliacion();
			
			if(!(pago==null)) {
				boolean operacion = pago.reembolso(tarjeta);
				if (operacion == true) {
					VBox Res = new VBox();
					Label Tit = new Label("...RESULTADO...");
					Tit.setFont(new Font("Times New Roman",20));
					Tit.setTextFill(Color.DARKBLUE);
					Tit.setTextAlignment(TextAlignment.CENTER);
					Tit.setAlignment(Pos.CENTER);
					Res.getChildren().add(Tit);
					
					HBox Reemb = new HBox();
					Label l2 = new Label("REEMBOLSO EXITOSO");
					l2.setFont(new Font("Times New Roman",14));
					l2.setTextFill(Color.DARKBLUE);
					l2.setTextAlignment(TextAlignment.CENTER);
					l2.setAlignment(Pos.CENTER);
					Res.getChildren().add(l2);
					
					Label l3 = new Label("El reembolso del tiquete con codigo:-->"
							+ pago.getCodigo()+" <--\nSE HA REALIZADO CORRECTAMENTE.\n"
									+ "MONTO DEVUELTO: "+pago.getCostoTotal());
					l3.setFont(new Font("Times New Roman",20));
					l3.setTextFill(Color.DARKGREEN);
					l3.setTextAlignment(TextAlignment.CENTER);
					Reemb.getChildren().add(l3);
					
					
					Image image2 = new Image(getClass().getResourceAsStream("/imagenes/Money.png"));
					ImageView ImT1= new ImageView(image2);
					ImT1.setFitHeight(150);
					ImT1.setFitWidth(150);
					Reemb.getChildren().add(ImT1);
					Reemb.setSpacing(30);
					Reemb.setAlignment(Pos.CENTER);
					
					Label l4 = new Label("ASISTENCIA CANCELADA CORRECTAMENTE");
					l4.setFont(new Font("Times New Roman",14));
					l4.setTextFill(Color.DARKGREEN);
					l4.setTextAlignment(TextAlignment.CENTER);
					Res.getChildren().add(l4);
					
					Res.setSpacing(15);
					Res.getChildren().add(Reemb);
					Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
					Res.setStyle("-fx-background-color: lightskyblue;");
					
					Funcional.getP2().getChildren().add(Res);
					
				}else {
					VBox Res = new VBox();
					Label Tit = new Label("...RESULTADO...");
					Tit.setFont(new Font("Times New Roman",20));
					Tit.setTextFill(Color.DARKBLUE);
					Tit.setTextAlignment(TextAlignment.CENTER);
					Tit.setAlignment(Pos.CENTER);
					Res.getChildren().add(Tit);
					
					HBox Reemb = new HBox();
					Label l2 = new Label("REEMBOLSO VENCIDO");
					l2.setFont(new Font("Times New Roman",14));
					l2.setTextFill(Color.DARKBLUE);
					l2.setTextAlignment(TextAlignment.CENTER);
					l2.setAlignment(Pos.CENTER);
					Res.getChildren().add(l2);
					
					Label l3 = new Label("El reembolso del tiquete con codigo: -->"
							+ pago.getCodigo()+"<--\nNO pudo efectuar la transaccion.\n"
									+ "MONTO DEVUELTO: "+0);
					l3.setFont(new Font("Times New Roman",20));
					l3.setTextFill(Color.DARKGREEN);
					l3.setTextAlignment(TextAlignment.CENTER);
					Reemb.getChildren().add(l3);
					
					
					Image image2 = new Image(getClass().getResourceAsStream("/imagenes/F.png"));
					ImageView ImT1= new ImageView(image2);
					ImT1.setFitHeight(150);
					ImT1.setFitWidth(150);
					Reemb.getChildren().add(ImT1);
					Reemb.setSpacing(30);
					Reemb.setAlignment(Pos.CENTER);
					
					Label l4 = new Label("ASISTENCIA CANCELADA CORRECTAMENTE");
					l4.setFont(new Font("Times New Roman",14));
					l4.setTextFill(Color.DARKGREEN);
					l4.setTextAlignment(TextAlignment.CENTER);
					Res.getChildren().add(l4);
					
					Res.setSpacing(15);
					Res.getChildren().add(Reemb);
					Res.setBorder(new Border(new BorderStroke(Color.DARKORANGE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
					Res.setStyle("-fx-background-color: lemonchiffon;");
					
					Funcional.getP2().getChildren().add(Res);
					/*a.setAlertType(AlertType.ERROR);
					a.setTitle("REEMBOLSO VENCIDO");
					a.setHeaderText("El tiempo para realizar el reembolso se ha excedido");
					a.setContentText("Faltan 24 horas o menos para el evento. La devolucion del dinero"
							+ "\nno es posible.");
					System.out.println("Lo sentimos, faltan 24 horas o menos para el evento. No aplicas para reembolso");
					System.out.println("Asistencia cancelada correctamente");*/
				}
			}else {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("CodeError");
				a.setHeaderText("No ha seleccionado el codigo");
				a.setContentText("Seleccione el codigo del tiquete.");
				a.showAndWait();
			}
				
			}else {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("El tiquete ya ha sido pagado");
				a.setContentText("Seleccione otro tiquete.");
				a.showAndWait();
			}
			
			
			
		/*Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al cliente que esta loggeado
		
		if(!usuario.getTiquetes().isEmpty()) {
		System.out.println("Lista de sus tiquetes: ");
		usuario.mostrarTicketsPag();
		System.out.println("Digite el numero de la lista, correspondiente al tiquete al cual desea solicitar un reembolso y cancelar su asistencia");
		
		Tiquete tiquete=null;
		do{
			int numero = sc.nextInt();
			tiquete = usuario.seleccionarTiquete(numero);
			if(tiquete==null) {
				System.out.println("AVISO: El tiquete seleccionado no se encuentra disponible");
			}
		}while(tiquete==null);
		
		
		Pago pago = tiquete.getRefPago();
		
		Tarjeta_des tarjeta = usuario.getAfiliacion();
		
		if(pago.isPagado()) {
			boolean operacion = pago.reembolso(tarjeta);
			if (operacion == true) {
				System.out.println("Reembolso exitoso!");
				System.out.println("Asistencia cancelada correctamente");
			}
			else {
				System.out.println("Lo sentimos, faltan 24 horas o menos para el evento. No aplicas para reembolso");
				System.out.println("Asistencia cancelada correctamente");
			}
		}else {
			System.out.println("No se ha efectuado el pago del tiquete primero");
		}
		
		
		}else {
			System.out.println("No posee tiquetes disponibles a pagar");
		}*/
	}

}
