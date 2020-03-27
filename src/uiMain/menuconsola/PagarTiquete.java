package uiMain.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionInfoTicket;
import gui.Fun.oidor.ActionPayTicket;
import gui.Fun.oidor.ActionSetEvent;
//import gui.Fun.oidor.ActionPayTicket;
import gui.Fun.oidor.AddPayTicketInTextField;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uiMain.menuconsola.OpcionDeMenu;

public class PagarTiquete extends OpcionDeMenu{
	
	private static FieldPanel T;
	public static FieldPanel getT() {
		return T;
	}
	public String mostrar() {
		return "Pagar Tiquete";
	}
	
	public void ejecutar() {
		
		//"-fx-background-color: green;"
		Funcional.getP2().getChildren().clear();
		
		Label nameFun = new Label((new PagarTiquete()).mostrar());
		nameFun.setFont(new Font("Times New Roma",20));
		nameFun.setTextFill(Color.GRAY);
		nameFun.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(nameFun);
		
		Label descripF = new Label("Esta funcionalidad le permite pagar un tiquete previamente generado." 
				+ "\n" + "Seleccione un tiquete (Presione Ver Mas para ver los detalles" + "\n" + 
				"Presione Aceptar para pagar el tiquete" + "\n" + 
				"Si ya pago el tiquete, el programa se lo indicara");
		
		descripF.setFont(new Font("Times New Roma",20));
		descripF.setTextFill(Color.GRAY);
		descripF.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.DOTTED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(descripF);
		
		ComboBox listTiq = new ComboBox();
		listTiq.setPromptText("DEUDAS PENDIENTES");
		
		FieldPanel.getSoporte().getChildren().clear();
		
		T = new FieldPanel("Criterio",new String[] {"Codigo"},"Numero Codigo",null,new Boolean[] {false});
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
		
		ActionDelete M21 = new ActionDelete(T);
		Delet.setOnAction(M21);
		
		ActionPayTicket M22 = new ActionPayTicket();
		Acep.setOnAction(M22);
		
		Funcional.getP2().getChildren().add(Botons);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
		
		if(!usuario.getTiquetes().isEmpty()) {
			ArrayList<Integer> deudas = usuario.mostrarTiquetesSinPagar();
			for(int i=0;i<deudas.size();i++) {
				listTiq.getItems().add(""+deudas.get(i));
			}
			AddPayTicketInTextField M23 = new AddPayTicketInTextField();
			listTiq.setOnAction(M23);
		}else {
			//NotFoundTicketException
		}
		
		Button verMas = new Button("Ver mas...");
		FieldPanel.getSoporte().add(verMas, 3, 1);
		FieldPanel.getSoporte().add(listTiq, 2, 1);
		FieldPanel.getSoporte().setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		FieldPanel.getSoporte().setAlignment(Pos.CENTER);
		
		
		/*Scanner sc = new Scanner(System.in);
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		if(!usuario.getTiquetes().isEmpty()) {
			System.out.println("Lista de sus tiquetes: ");
			usuario.mostrarTiquetes();
			System.out.println("Digite el numero de la lista, correspondiente al tiquete que desea pagar");
			
			Tiquete tiquete=null;	
			do {
				int numero = sc.nextInt();
				tiquete = usuario.seleccionarTiquete(numero);
				if(tiquete.getRefPago().isPagado()) {
					System.out.println("AVISO: El tiquete ya ha sido pagado");
					break;
				}else {
					Pago pago = tiquete.getRefPago();
					Tarjeta_des tarjeta = usuario.getAfiliacion();
					
					boolean transaccion = pago.transaccion(tarjeta);
					if (transaccion == true) {
						System.out.println("Transaccion exitosa");
						System.out.println("Resumen de la transaccion: ");
						System.out.println("Codigo del pago: " + pago.getCodigo());
						System.out.println("Valor del tiquete: " + pago.getCostoTiquete());
						System.out.println("Valor total (iva incluido): " + pago.getCostoTotal());
					}
					else {
						System.out.println("No tienes saldo suficiente");
					}
				}
			}while(tiquete==null);
			
		}else {
			System.out.println("No posee tiquetes disponibles a pagar");
		}*/
		
				
	}
	
}