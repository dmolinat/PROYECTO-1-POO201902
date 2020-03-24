package uiMain.menuconsola;

import java.util.Scanner;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.users.User_R;
import gui.Ini;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
			Label L4 = new Label("Usuario: ");
			L4.setFont(new Font("Times New Roman",15));
			L4.setTextFill(Color.DARKBLUE);
			us = new TextField();
			
			Label L5 = new Label("Contraseña: ");
			L5.setFont(new Font("Times New Roman",15));
			L5.setTextFill(Color.DARKBLUE);
			pas = new TextField();
			
			
			Ini.getP3().add(L4, 0, 0);
			Ini.getP3().add(us, 1, 0,4,1);
			Ini.getP3().add(L5, 0, 1);
			Ini.getP3().add(pas, 1, 1,4,1);
			
			Button bAc = new Button("Aceptar");
			AceptB M5 = new AceptB();
			bAc.setOnAction(M5);
			Ini.getP3().add(bAc, 2, 4);
			
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
				a1.setHeaderText("La cuenta ingresada no esta registrada.");
				a1.setContentText("Ingrese los datos nuevamente.");
				a1.showAndWait();
			}else {
				a1.setHeaderText("¡HAS INICIADO SESION!");
				a1.showAndWait();
			}
			
			
		}
		
	}

	@Override
	public String mostrar() {
		return "Iniciar Sesion";
	}
	
}
