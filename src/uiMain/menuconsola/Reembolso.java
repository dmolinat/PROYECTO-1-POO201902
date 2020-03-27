package uiMain.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionPayTicket;
import gui.Fun.oidor.ActionReembolsoEvent;
import gui.Fun.oidor.AddPayTicketInTextField;
import javafx.geometry.Pos;
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
import gestorAplicacion.transaccion.Tarjeta_des;

public class Reembolso extends OpcionDeMenu {
	private FieldPanel R;
	public String mostrar() {
		return "Solicitar reembolso y cancelar asistencia: ";
	}
	
	public void ejecutar() {
		//"-fx-background-color: green;"
				Funcional.getP2().getChildren().clear();
				
				Label nameFun = new Label((mostrar()));
				nameFun.setFont(new Font("Times New Roma",20));
				nameFun.setTextFill(Color.GRAY);
				nameFun.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				Funcional.getP2().getChildren().add(nameFun);
				
				Label descripF = new Label("Esta opcion le permite cancelar su asistencia, y solicitar un reembolso.\n"+
							"1. Seleccione el tiquete que desea reembolsar\n" + "2. Presione el boton aceptar\n"+ 
								 "El programa le indicara si el reembolso fue exitoso o no");
				descripF.setFont(new Font("Times New Roma",20));
				descripF.setTextFill(Color.GRAY);
				descripF.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.DOTTED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
				Funcional.getP2().getChildren().add(descripF);
				
				ComboBox listTiq = new ComboBox();
				listTiq.setPromptText("TIQUETES PAGADOS");
				
				FieldPanel.getSoporte().getChildren().clear();
				R = new FieldPanel("Criterio",new String[] {"Codigo"},"Numero Codigo",null,new Boolean[] {false});
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
				
				ActionDelete M21 = new ActionDelete(R);
				Delet.setOnAction(M21);
				
				ActionReembolsoEvent M22 = new ActionReembolsoEvent();
				Acep.setOnAction(M22);
				
				Funcional.getP2().getChildren().add(Botons);
	
				Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
				
				if(!usuario.getTiquetes().isEmpty()) {
					ArrayList<Integer> pag = usuario.mostrarTicketsPag();
					for(int i=0;i<pag.size();i++) {
						listTiq.getItems().add(""+pag.get(i));
					}
					AddPayTicketInTextField M23 = new AddPayTicketInTextField();
					listTiq.setOnAction(M23);
				}
				
				
				Button verMas = new Button("Ver mas...");
				FieldPanel.getSoporte().add(verMas, 3, 1);
				FieldPanel.getSoporte().add(listTiq, 2, 1);
				
				FieldPanel.getSoporte().setAlignment(Pos.CENTER);
				Funcional.getP2().setAlignment(Pos.CENTER);
				

		
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