package gestorAplicacion.users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.SaveObject;
import gestorAplicacion.Funcion;
import gui.Ini;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import uiMain.Start;
import uiMain.menuconsola.Login;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.NewUser;
import gestorAplicacion.DatosTeatro;

public abstract class User_R implements User{
	private String nombre;
	private String apellido;
	private String login;
	private String pass;
	private String document;
	private Integer edad = 0;
	private String sexo = ""; //M o F
	
	User_R(){
	}
	
	User_R(String nombre, String apellido, String login, String pass, String document,Integer edad,String sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	User_R(String nombre, String apellido, String login, String pass, String document, Integer edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;
	}
	
	//Crear USUARIO:
	public void crearUser(int Op) {
		
		DatosTeatro.Datos.clear();
		Scanner in = new Scanner(System.in);
		String aux;Long aux1; Integer aux2;
		
		//Ingrese el nombre
		
		//Se ingresarán los datos de forma secuencial
		Enter M6 = new Enter();
		TextField M = new TextField();		
		
		Ini.getP3().getChildren().clear();
		Ini.getP3().add(M,3,3);
		M.setOnAction(M6);	
		
		Label LN = new Label();
		LN.setFont(new Font("Times New Roman",14));
		LN.setTextFill(Color.DARKGREEN);
		
		Ini.getP3().add(LN, 0, 3);
		
		Label T = new Label("...REGISTRARSE...");
		T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
		T.setTextFill(Color.CRIMSON);
		Ini.getP3().add(T,0,2,5,1);
		
		LN.setText("Ingrese el NOMBRE: ");
		
		
		
			
		/*do {
			LN.setText("Ingrese el APELLIDO: ");
			if(M6.getVal()) {
				break;
			}
		}while(M6.getVal());
		
		
		/*do {
				System.out.print("Ingrese el nombre: "); aux=in.next();
				if(aux.equals("")||aux.contains(" ")) {
					System.out.println("===========================");
					System.out.println("!!ERROR: Nombre invalido¡¡");
					System.out.println("===========================");
					aux=null;
		}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numero¡¡");
					System.out.println("=========================================================");
					aux=null;
				}	
			}while(aux==null);
			D.add(aux);
			
			//Ingresar el apellido
			aux=null;
			do {
				System.out.print("Ingrese el apellido: ");aux=in.next();
				
				if(aux.equals("")||aux.contains(" ")) {
					System.out.println("============================");
					System.out.println("!!ERROR: Apellido invalido¡¡");
					System.out.println("============================");
					aux=null;
				}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numeros¡¡");
					System.out.println("=========================================================");
					aux=null;
				}	
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Login
			aux=null;
			do {
				System.out.print("Ingrese un usuario: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")||existId(aux)||aux.length()<5){
					System.out.println("!!ERROR: Login invalido¡¡");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Pass
			aux=null;
			do {
				System.out.print("Ingrese una contraseña: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")||aux.length()<6){
					System.out.println("!!ERROR: Login invalido¡¡");
					aux=null;
				}
				
			}while(aux==null);
			D.add(aux);
			
			
			//Ingresar Documento:
			aux=null;
			do {
				System.out.print("Ingrese su Documento: ");
				aux=in.next();
				
				if(aux.equals("")||aux.contains(" ")||!isNumeric(aux)) {
					System.out.println("!!ERROR: Documento Invalido¡¡");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Ingresar edad:
			do {
					
				System.out.print("Ingrese su Edad: ");aux2=in.nextInt();
					
				if(aux2<18) {
					System.out.println("!!ERROR: No eres mayor de edad¡¡");
					aux2=null;
				}else if(aux2>199) {
					System.out.println("!!ERROR: Edad Invalida¡¡");
					aux2=null;
				}
					
			}while(aux2==null);
			D.add(aux2);
			
			//Ingresar Sexo:
			aux=null;
			do {
				System.out.print("Ingrese su sexo: ");aux=in.next();
				if((!aux.equals("M")&&!aux.equals("F"))||aux.equals("")||aux.contains(" ")) {
					System.out.println("!!ERROR: Sexo Invalido¡¡");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);*/
			
			//return new Cliente();
			//SaveObject.Write(SaveObject.U_Cli, D);
			/*return new Cliente((String) D.get(0),(String)D.get(1),
						(String)D.get(2),(String)D.get(3),(String)D.get(4),
						(Integer)D.get(5));*/
			
		}
	
	public static boolean LogIn(String user,String pass) {
		Scanner in = new Scanner(System.in);
		boolean x=false;
		int opc=0;
		
		int indCli=-1;
		for(int i=0;i<(DatosTeatro.U).size();i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(user) && (((DatosTeatro.U).get(i)).getPass()).equals(pass)) {
				indCli=i;
				DatosTeatro.userLive = (DatosTeatro.U).get(indCli);
				x=true;
				break;
			}else {
				x=false;
			}
		}	
		return x;
	}
	
	//Método para comprobar que el usuario ya existe.
	
	private boolean existId(String Id) {
		for(int i=0; i < (DatosTeatro.U).size()-1;i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(Id)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumeric(String document) {
		try {
			Integer x = Integer.parseInt(document);
		}catch (NumberFormatException e) {
			return false;
		}	
		return true;
	}
	
	public class Enter implements EventHandler<ActionEvent>{
		public void handle(ActionEvent E) {
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			
			if(aux.equals("")||aux.contains(" ")) {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡Nombre Invalido!");
				a.setContentText("El campo 'Nombre' no debe estar vacio.\n"
						+ "Ingrese el dato nuevamente");					
				a.showAndWait();
			}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
					aux.contains("3")||aux.contains("4")||aux.contains("5")||
					aux.contains("6")||aux.contains("7")||aux.contains("8")||
					aux.contains("9")) {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡Nombre Invalido!");
				a.setContentText("El campo 'Nombre' no debe llevar numeros.\n"
						+ "Ingrese el dato nuevamente");
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux);
				
				//Ingresar apellido
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				Label L = new Label("Ingrese el APELLIDO: ");
				TextField MA = new TextField();
				CA M7 = new CA();
				
				
				Ini.getP3().add(MA,3,3);
				MA.setOnAction(M7);	
				
				L.setFont(new Font("Times New Roman",14));
				L.setTextFill(Color.DARKGREEN);
				Ini.getP3().add(L, 0, 3);
				
			}		
		}
	}
	
	public class CA implements EventHandler<ActionEvent>{

		public void handle(ActionEvent E) {
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			
			if(aux.equals("")||aux.contains(" ")) {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡Nombre Invalido!");
				a.setContentText("El campo 'Apellido' no debe estar vacio.\n"
						+ "Ingrese el dato nuevamente");					
				a.showAndWait();
			}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
					aux.contains("3")||aux.contains("4")||aux.contains("5")||
					aux.contains("6")||aux.contains("7")||aux.contains("8")||
					aux.contains("9")) {
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡Nombre Invalido!");
				a.setContentText("El campo 'Apellido' no debe llevar numeros.\n"
						+ "Ingrese el dato nuevamente");
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux);
				//Ingrese el usuario
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				Label L = new Label("Ingrese el Usuario: ");
				TextField MA = new TextField();
				CU M8 = new CU();
				
				Ini.getP3().add(MA,3,3);
				MA.setOnAction(M8);	
				
				L.setFont(new Font("Times New Roman",14));
				L.setTextFill(Color.DARKGREEN);
				
				Ini.getP3().add(L, 0, 3);
			}
			
		}
		
	}
	
	public class CU implements EventHandler<ActionEvent>{

		public void handle(ActionEvent E) {
			
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			
			if(aux.equals("")||aux.contains(" ")||existId(aux)||aux.length()<5){
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡¡Login invalido!!");
				a.setContentText("El campo 'Usuario' no debe estar vacio,\n"
						+ "no debe tener menos de 5 caracteres\n"
						+ "y el usuario debe ser nuevo (No se aceptan nombre de usuarios ya existentes).\n"
						+ "Ingrese el dato nuevamente.");					
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux);
				
				//Ingrese contraseña:
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				Label L = new Label("Ingrese la contraseña: ");
				TextField MA = new TextField();
				CC M9 = new CC();
				
				Ini.getP3().add(MA,3,3);
				MA.setOnAction(M9);	
				
				L.setFont(new Font("Times New Roman",14));
				L.setTextFill(Color.DARKGREEN);
				
				Ini.getP3().add(L, 0, 3);
			}
		}
	}
	
	public class CC implements EventHandler<ActionEvent>{
		public void handle(ActionEvent E) {
			
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			
			if(aux.equals("")||aux.contains(" ")||aux.length()<6){
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡¡Contraseña invalida!!");
				a.setContentText("El campo 'Contraseña' no debe estar vacio y \n"
						+ "no debe tener menos de 6 caracteres\n"
						+ "Ingrese el dato nuevamente.");					
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux);
				//Ingrese el documento
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				Label L = new Label("Ingrese el DOCUMENTO: ");
				TextField MA = new TextField();
				CD M10 = new CD();
				
				Ini.getP3().add(MA,3,3);
				MA.setOnAction(M10);	
				
				L.setFont(new Font("Times New Roman",14));
				L.setTextFill(Color.DARKGREEN);
				
				Ini.getP3().add(L, 0, 3);
				
			}
			
		}
	}
	
	public class CD implements EventHandler<ActionEvent>{

		public void handle(ActionEvent E) {
			
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			
			if(aux.equals("")||aux.contains(" ")||!isNumeric(aux)){
				a.setAlertType(AlertType.WARNING);
				a.setTitle("AVISO");
				a.setHeaderText("¡¡Documento Invalido!!");
				a.setContentText("El campo 'Documento' no debe contener letras\n"
						+ "y no debe tener mas de 11 digitos");					
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux);
				//Ingrese la edad
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				Label L = new Label("Ingrese la EDAD: ");
				TextField MA = new TextField();
				CE M10 = new CE();
				
				Ini.getP3().add(MA,3,3);
				MA.setOnAction(M10);	
				
				L.setFont(new Font("Times New Roman",14));
				L.setTextFill(Color.DARKGREEN);
				
				Ini.getP3().add(L, 0, 3);
			}
			
		}
		
	}
	
	public class CE implements EventHandler<ActionEvent>{

		public void handle(ActionEvent E) {
			Alert a = new Alert(AlertType.NONE);
			Object Tf = E.getSource();
			String aux = ((TextField) Tf).getText();
			Integer aux2 = Integer.parseInt(aux);
			
			a.setAlertType(AlertType.WARNING);
			a.setTitle("AVISO");
			a.setHeaderText("¡¡Edad Invalida!!");
			
			if(aux2<18) {
				a.setContentText("Debes ser mayor de edad. (>18)");
				a.showAndWait();
			}else if(aux2>199) {
				a.setContentText("Numero excedido de los límites. (<199)");
				a.showAndWait();
			}else {
				DatosTeatro.Datos.add(aux2);
				//Genero				
				Ini.getP3().getChildren().clear();
				Label T = new Label("...REGISTRARSE...");
				T.setFont(Font.font("Times New Roman",FontWeight.BOLD,20));
				T.setTextFill(Color.CRIMSON);
				Ini.getP3().add(T,0,2,5,1);
				
				ComboBox gen = new ComboBox();
				gen.setPromptText("Generos");
				gen.getItems().addAll("F","M");
				
				Ini.getP3().add(gen, 0, 3,4,1);
				CS M12 = new CS();
				gen.setOnAction(M12);
				
			}
		}
		
	}
	
	public class CS implements EventHandler<ActionEvent>{
		
		
		public void handle(ActionEvent E) {
			
			Alert a = new Alert(AlertType.NONE);
			Object C = E.getSource();
			String aux = ((String)((ComboBox) C).getValue());
			TextField M = new TextField(aux);
			M.setEditable(false);
			Ini.getP3().add(M, 6, 3,4,1);
			
			Ini.getP3().setHgap(10);
			DatosTeatro.Datos.add(aux);
			
			Label L1 = new Label("Oprima 'Validar Datos': Para crear el usuario\n"
					+ "o 'Cancelar': Para deshacer.");
			Ini.getP3().add(L1, 3, 6,4,1);
			Button val = new Button("ValidarDatos");
			Button can = new Button("Cancelar");
			Ini.getP3().setPrefSize(300, 300);
			Ini.getP3().add(can, 0, 5,4,1);
			Ini.getP3().add(val, 0, 4,4,1);
			BV M13 = new BV();
			can.setOnAction(M13);
			val.setOnAction(M13);
		}
		
	}
	
	public class BV implements EventHandler<ActionEvent>{
		public void handle(ActionEvent B) {
			
			Alert a = new Alert(AlertType.INFORMATION);
			Object b = B.getSource();
			if(((Button)b).getText().equals("ValidarDatos")) {
				(new NewUser()).ejecutar();
				a.setTitle("AVISO");
				a.setHeaderText("¡Su cuenta se ha creado EXITOSAMENTE!");
				a.showAndWait();
				(new Login()).ejecutar();
			}else {
				DatosTeatro.Datos.clear();
				(new Cliente()).crearUser(1);
			}
			
		}
		
	}
	
	//Get y Set
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login=login;
	}
	
	public String getDocument() {
		return this.document;
	}
	public void setDocument(String document) {
		this.document=document;
	}
	
	public Integer getEdad() {
		return this.edad;
	}
	public void setEdad(Integer edad) {
		this.edad=edad;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo=sexo;
	}	
}
