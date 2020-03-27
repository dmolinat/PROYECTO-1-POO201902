package uiMain.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.Fun.oidor.ActionChangeChair;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionPayTicket;
import gui.Fun.oidor.AddPayTicketInTextField;
import gui.Fun.oidor.AddPayWithChairEvent;
import gui.Fun.oidor.TableroAsientos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import uiMain.menuconsola.OpcionDeMenu;

public class CambiarAsiento extends OpcionDeMenu {
	
	private static FieldPanel campoSetChair;
	public static FieldPanel getcampoSetChair() {
		return campoSetChair;
	}
	
	public String mostrar() {
		return "Cambiar Asiento: ";
	}
	
	public void ejecutar() {
		
		Cliente usuario = (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
		//"-fx-background-color: green;"
		Funcional.getP2().getChildren().clear();
		
		Label nameFun = new Label(mostrar());
		nameFun.setFont(new Font("Times New Roma",20));
		nameFun.setTextFill(Color.GRAY);
		nameFun.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(nameFun);
		
		Label descripF = new Label("Esta opcion le permite cambiar su asiento\n" + "(siempre y cuando no haya pagado el tiquete aun)\n" 
				+ "1. Seleccione el tiquete\n" + "2. Seleccione el nuevo asiento\n"
				+ "3. Presione aceptar para confirmar su eleccion");
		descripF.setFont(new Font("Times New Roma",20));
		descripF.setTextFill(Color.GRAY);
		descripF.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.DOTTED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(descripF);
		
		
		FieldPanel.getSoporte().getChildren().clear();
		
		campoSetChair = new FieldPanel("Data: ",new String[] {"Codigo","Asiento"},"Valor seleccionado",null,new Boolean[] {false,false});
		FieldPanel.getSoporte().setBorder(new Border(new BorderStroke(Color.DODGERBLUE,BorderStrokeStyle.DASHED,CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		FieldPanel.getSoporte().setAlignment(Pos.CENTER);
		FieldPanel.getSoporte().setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
		Funcional.getP2().getChildren().add(campoSetChair.getSoporte());
		Funcional.getP2().setAlignment(Pos.CENTER);
		
		ComboBox listTiq = new ComboBox();
		listTiq.setPromptText("TIQUETES DISPONIBLES");
		if(!usuario.getTiquetes().isEmpty()) {
			ArrayList<Integer> deudas = usuario.mostrarTiquetesSinPagar();
			for(int i=0;i<deudas.size();i++) {
				listTiq.getItems().add(""+deudas.get(i));
			}
			AddPayWithChairEvent M23 = new AddPayWithChairEvent();
			listTiq.setOnAction(M23);
		}else {
			//NotFoundTicketException
		}
		
		Button verMas = new Button("Ver mas...");
		FieldPanel.getSoporte().add(verMas, 3, 1);
		FieldPanel.getSoporte().add(listTiq, 2, 1);
		FieldPanel.getSoporte().setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		FieldPanel.getSoporte().setAlignment(Pos.CENTER);
		
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
		
		ActionDelete M21 = new ActionDelete(campoSetChair);
		Delet.setOnAction(M21);
		
		ActionChangeChair M22 = new ActionChangeChair();
		Acep.setOnAction(M22);
		
		Funcional.getP2().getChildren().add(Botons);
		
		

		
		
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