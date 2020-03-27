package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.users.User_R;
import gui.Ini;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uiMain.Start;
import gestorAplicacion.users.Cliente;

public class Login extends OpcionDeMenu {
	public String user;
	public String pass;
	TextField us;
	TextField pas;
	
	@Override
	public void ejecutar() {
		//do {
			
			Ini.getP3().getChildren().clear();
			
			Label L3 = new Label("INICIAR SESION");
			L3.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));
			L3.setTextFill(Color.DARKBLUE);
			L3.setAlignment(Pos.CENTER);
			Ini.getP3().add(L3,0, 0,4,1);
			
			Label L4 = new Label("Usuario: ");
			L4.setFont(new Font("Times New Roman",20));
			L4.setTextFill(Color.DARKBLUE);
			us = new TextField();
			
			
			Label L5 = new Label("Contraseña: ");
			L5.setFont(new Font("Times New Roman",20));
			L5.setTextFill(Color.DARKBLUE);
			pas = new TextField();
			
			
			Ini.getP3().add(L4, 0, 1);
			Ini.getP3().add(us, 1, 1,4,1);
			Ini.getP3().add(L5, 0, 2);
			Ini.getP3().add(pas, 1, 2,4,1);
			Ini.getP3().setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
			Ini.getP3().setStyle("-fx-background-color: white;");
			
			Button bAc = new Button("Aceptar");
			bAc.setPrefWidth(80);
			bAc.setStyle("-fx-background-color: blue;");
			bAc.setTextFill(Color.WHITESMOKE);
			
			AceptB M5 = new AceptB();
			bAc.setOnAction(M5);
			Ini.getP3().add(bAc, 2, 4);
			
			Ini.getP3().setHgap(10);
			Ini.getP3().setVgap(10);
			
			//System.out.print("Usuario: ");user=in.next();
			//System.out.print("Contraseña: ");pass=in.next();
			//System.out.print("Presione 1: Para aceptar - Presione 2: Para cancelar ");op=in.next();
			//if(op.equals("2")) {
				//System.out.print("¿Desea continuar iniciando sesión? -Y para Sí , N para No-: ");op=in.next();
				//if(op.equals("N")) {
					//break;
				//}else {
					//user=null;pass=null;
				//}
			//}
			
			//if(!op.equals("Y")&&!User_R.LogIn(user,pass).equals("AVISO: Cuenta no registrada")){
			//	System.out.println(User_R.LogIn(user,pass));
			//	((Cliente)DatosTeatro.userLive).Opci();
			//}else if(!op.equals("Y")){
			//	System.out.println(User_R.LogIn(user,pass));
			//	user=null;
			//	pass=null;
			//}
			
		//}while(user==null && pass==null);
	}
	
	class AceptB implements EventHandler<ActionEvent>{
		Alert a1 = new Alert(AlertType.INFORMATION);
		
		public void handle(ActionEvent B) {
			a1.setTitle("AVISO");
			//User y TextField van dentro del manejador.	
			user=us.getText();
			pass=pas.getText();
			if(!User_R.LogIn(user,pass)){
				//LoginException
				a1.setHeaderText("La cuenta ingresada no esta registrada.");
				a1.setContentText("Ingrese los datos nuevamente.");
				a1.showAndWait();
			}else {
				a1.setHeaderText("¡HAS INICIADO SESION!");
				a1.showAndWait();
				
				Ini.getP3().getChildren().clear();
				Label L = new Label("TEATROS S.A                 ");
				L.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				L.setTextFill(Color.BLACK);
				Ini.getP3().add(L, 0, 0,4,1);
				
				ComboBox C = new ComboBox();
				C.setPromptText("Herramientas");
				C.getItems().addAll((new EscogerEvento()).mostrar(),(new PagarTiquete()).mostrar(),(new Reembolso()).mostrar(),
						(new CambiarAsiento()).mostrar(),(new RecargarTarjetad()).mostrar());
				NextS S2 = new NextS();
				C.setOnAction(S2);
				Ini.getP3().add(C, 0, 2);
				
				Label L1 = new Label("Bienvenido a nuestro teatro\n"
						+ "en el podrá realizar una serie de operaciones\n"
						+ "que harán de su expereciencia en nuestro sitio\n"
						+ "algo comodo y agradable. Para empezar seleccione\n"
						+ "alguna de nuestras 'HERRAMIENTAS'. Para mas informacion\n"
						+ "de estas en el menu de procesos y consultas tendra\n"
						+ "acceso a una descripcion de su funcion.");
				L1.setFont(new Font("Times New Roman",14));
				L1.setTextFill(Color.DARKBLUE);
				Ini.getP3().add(L1, 0, 1,7,1);
			}
		}
		
		//Segunda Scene
		class NextS implements EventHandler<ActionEvent>{
			public void handle(ActionEvent E) {
				Object ComB = E.getSource();
				String f = (String) ((ComboBox)ComB).getValue();
				
				if(f.equals((new EscogerEvento()).mostrar())) {
					(new EscogerEvento()).ejecutar();
					Funcional.setScene();
				}else if(f.equals(new PagarTiquete().mostrar())){
					(new PagarTiquete()).ejecutar();
					Funcional.setScene();
				}else if(f.equals(new Reembolso().mostrar())){
					(new Reembolso()).ejecutar();
					Funcional.setScene();
				}else if(f.equals(new CambiarAsiento().mostrar())){
					(new CambiarAsiento()).ejecutar();
					Funcional.setScene();
				}
				
			}
		}
		
		
	}

	@Override
	public String mostrar() {
		return "Iniciar Sesion";
	}
	
}
