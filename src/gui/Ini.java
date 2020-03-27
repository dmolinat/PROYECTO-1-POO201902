package gui;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import gestorAplicacion.users.Cliente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import uiMain.Start;
import uiMain.menuconsola.Descripcion;
import uiMain.menuconsola.Login;
import uiMain.menuconsola.NewUser;
import uiMain.menuconsola.Salir;

public class Ini extends Application {
	static int con=2;
	
	private static GridPane P3 = new GridPane();
	public static GridPane getP3() {
		return P3;
	}
	
	private static Stage vent = new Stage();
	public static Stage getVent() {
		return vent;
	}
	
	private static Scene s1 = new Scene(new Label());
	public static Scene getScene1() {
		return s1;
	}
	
	private static Label LD = new Label("");
	
	public static Label getLD() {
		LD.setFont(new Font("Times New Roman",15));
		return LD;
	}
		
	
	private static Alert a = new Alert(AlertType.NONE);
	public static Alert getAlertA() {
		return a;
	}
	
	
	@Override
	public void start(Stage stg) throws Exception {
		vent = stg;
		Start.On();
		stg.setTitle("Inicio");
		
		
		
		//Creacion de Panes:
		GridPane P1 = new GridPane();
		P1.setAlignment(Pos.CENTER);
		P1.setPrefSize(Double.MAX_VALUE,Double.MAX_VALUE);
		P1.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		P1.setPadding(new Insets(20,20,20,20));
		
		GridPane P2 = new GridPane();
		P2.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		P2.setAlignment(Pos.CENTER);
		P2.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
		P2.setPadding(new Insets(20,20,20,20));
		
		P1.setPadding(new Insets(15,15,15,15));
		P2.setPadding(new Insets(15,15,15,15));
		P2.setPrefWidth(500);
		
		
		P3.setPrefHeight(300);
		P3.setPrefWidth(300);
		P3.setPadding(new Insets(15,15,15,15));
		P3.setVgap(10);
		P1.setPrefSize(500, 500);
		P3.setAlignment(Pos.CENTER);
		P1.add(P3, 0, 1,4,1);
		
		
		//Imagenes (ImageView)
		GridPane P4 = new GridPane();
		P4.setAlignment(Pos.CENTER);
		Image image1 = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\ImT1.png"));
		ImageView ImT1= new ImageView(image1);
		ImT1.setFitHeight(200);
		ImT1.setFitWidth(350);
		
		//Controlador	
		Label Lim1 = new Label("Teatro:",ImT1);
		Lim1.setFont(new Font("Times New Roman",20));
		P4.add(Lim1, 0, 0,4,1);
		ImEnt M1 = new ImEnt();
		Lim1.setContentDisplay(ContentDisplay.BOTTOM);
		Lim1.setOnMouseEntered(M1);
		
		P4.setPrefHeight(450);
		P4.setPrefWidth(450);
		P1.add(P4, 0, 2,4,1);
		
		//Saludo
		GridPane P5 = new GridPane();
		P5.setAlignment(Pos.CENTER);
		Label L2 = new Label("¡BIENVENIDOS A LA APP TEATROS SA!"); //Cambiar tipo de letra,fuente,color,etc
		L2.setFont(new Font("Times New Roman",20));
		L2.setTextFill(Color.BLUE);
		L2.setTextAlignment(TextAlignment.CENTER);
		L2.setAlignment(Pos.CENTER);
		
		P5.add(L2, 0,0,4,1);
		
		LD.setTextAlignment(TextAlignment.CENTER);
		LD.setAlignment(Pos.CENTER);
		P5.setHgap(15);
		P5.setVgap(15);
		P5.add(LD, 0, 1,4,1);
		
		
		P5.setPrefHeight(200);
		P5.setPrefWidth(500);
		P5.setBorder(new Border(new BorderStroke(Color.DARKGRAY,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		P2.add(P5, 0, 0,4,1);
		P5.setAlignment(Pos.CENTER);
				
		//Hoja de Vida:
		GridPane P6 = new GridPane();
		P6.setAlignment(Pos.CENTER);
		Label L31= new Label("\n"
				+ "CREADORES:");
		L31.setTextAlignment(TextAlignment.CENTER);
		L31.setAlignment(Pos.CENTER);
		
		L31.setTextFill(Color.DARKRED);
		L31.setFont(new Font("Times New Roman",22));
		P6.add(L31, 3, 0);
		Label L3 = new Label("DENILSON ANDRES MOLINA TRUYOT\n"
				+ "\n"
				+ "SOBRE MI: Soy un estudiante con dos anos cursando la carrera\n"
				+ "de Ing.Sistemas en la Universidad Nacional de Comlombia. Se desempeñarme\n"
				+  "en los conceptos de estructura de datos y los estándares de eficiencia\n"
				+ "a nivel mundia. Doy lo mejor de mi en los proyectos y he tenido contactos\n"
				+ "con el desarrollo de software y edición de videos bajo ciertas plataformas.\n"
				+ "\n"
				+ "FORMACION:\n"
				+ "Bachiller: Colegio Ateneo Moderno de Santa Marta. Dic.2017\n"
				+ "Estudiante de Pregrado en Ing. Sistemas. Vigente.\n"
				+ "\n"
				+ "IDIOMAS:\n"
				+ "Ingles: B1-B2 (Medio-Alto)\n"
				+ "\n"
				+ "CONTACTO:\n"
				+ "Correo: dmolinat@unal.edu.co\n"
				+ "Telefono: 3154498506\n"
				+ "Santa Marta, Magdalena\n");
		
		//BORDEAR UN LABEL
		L3.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		L3.setTextAlignment(TextAlignment.CENTER);
		P6.add(L3, 0,1,4,1);
		P6.setHgap(10);
		P6.setVgap(10);
		P2.add(P6, 0,1,4,1);
		
		//Oidor de las hojas de vida
		HojClick M2 = new HojClick();
		L3.setOnMouseClicked(M2);
		
		
		//Menu de pantalla de Inicio
		VBox ContMen;
		MenuBar MenB = new MenuBar();
		Menu Men = new Menu("Info");
		MenuItem S = new MenuItem((new Salir()).mostrar());
		MenuItem D = new MenuItem((new Descripcion()).mostrar());
		Men.getItems().add(S);
		Men.getItems().add(D);
		MenB.getMenus().add(Men);
		
		//Oidores de opcion de Menu
		OpIni Op1 = new OpIni();
		S.setOnAction(Op1);
		OpIni Op2 = new OpIni();
		D.setOnAction(Op2);
		
		
		//Primeras 3 opciones de menu (Login y registrarse)
		Menu Men2 = new  Menu("Login");
		MenuItem Log = new MenuItem(new Login().mostrar());
		MenuItem Reg = new MenuItem(new NewUser().mostrar());
		Men2.getItems().add(Log);
		Men2.getItems().add(Reg);
		MenB.getMenus().add(Men2);
		//Oidores 
		OpIni Op3 = new OpIni();
		Log.setOnAction(Op3);
		OpIni Op4 = new OpIni();
		Reg.setOnAction(Op4);
		
		
		//Agregando el menuBar en el VBox
		ContMen = new VBox(MenB);
		ContMen.setPrefHeight(100);
		ContMen.setPrefWidth(100);
		P1.add(ContMen, 0,0,4,1);
		
		HBox Cont = new HBox(P1,P2);
		Cont.setSpacing(20);
		Cont.setAlignment(Pos.CENTER);
		
		s1 = new Scene(Cont,1200,700);
		vent.setScene(s1);
		
		vent.show();
		
		
	}
	
	
	
	
	//Cambiar imagenes
	class ImEnt implements EventHandler<MouseEvent>{

		public void handle(MouseEvent event){
			Object control = event.getSource();
			
			

			try {
				Image image = new Image(new FileInputStream(System.getProperty("user.dir") + "\\src\\imagenes\\"+"ImT"+con+".png"));
				ImageView Im = new ImageView(image);
				Im.setFitHeight(200);
				Im.setFitWidth(350);
				
				
				((Label)control).setGraphic(Im);
				if (con == 5) {
					con= 0;
				}
				con++;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	//Cambiar las hojas de vida
	static int i2=1;
	class HojClick implements EventHandler<MouseEvent>{
		public void handle(MouseEvent event) {			
			Object L = event.getSource();
			if(i2==4) {
				i2=0;
			}
			i2++;
			if(i2==1) {
				//Denilson
				((Label)L).setText("DENILSON ANDRES MOLINA TRUYOT\n"
						+ "\n"
						+ "SOBRE MI: Soy un estudiante con dos anos cursando la carrera\n"
						+ "de Ing.Sistemas en la Universidad Nacional de Comlombia. Se desempeñarme\n"
						+  "en los conceptos de estructura de datos y los estándares de eficiencia\n"
						+ "a nivel mundia. Doy lo mejor de mi en los proyectos y he tenido contactos\n"
						+ "con el desarrollo de software y edición de videos bajo ciertas plataformas.\n"
						+ "\n"
						+ "FORMACION:\n"
						+ "Bachiller: Colegio Ateneo Moderno de Santa Marta. Dic.2017\n"
						+ "Estudiante de Pregrado en Ing. Sistemas. Vigente.\n"
						+ "\n"
						+ "IDIOMAS:\n"
						+ "Ingles: B1-B2 (Medio-Alto)\n"
						+ "\n"
						+ "CONTACTO:\n"
						+ "Correo: dmolinat@unal.edu.co\n"
						+ "Telefono: 3154498506\n"
						+ "Santa Marta, Magdalena\n");
			}else if (i2==2){
				//Wilmar
				((Label)L).setText("WILMAR ANDRES GARCIA BEDOYA\n"
						+ "\n"
						+ "SOBRE MI: Soy estudiante de cuarto semestre de Ingenieria de Sistemas\n"
						+ "en la Universidad Nacional de Colombia, sede Medellin. He participado\n"
						+ "en el desarrollo de proyectos de software durante mas de un año, y me\n"
						+ "especializo en el area de la programacion orientada a objetos.\n"
						+ "Me gusta trabajar en equipo, y aprender cosas nuevas sobre el mundo\n"
						+ "de la programacion cada dia.\n"
						+ "\n"
						+ "FORMACIÓN:\n"
						+ "-Bachiller\n"
						+ "   Institucion Educativa Yarumito. Dic.2017\n"
						+ "-Estudiante de Pregrado en Ingenieria de Sistemas e Informatica\n"
						+ "   Universidad Nacional De Colombia, Sede Medellin. Vigente\n"
						+ "\n"
						+ "IDIOMAS:\n"
						+ "Español: Nativo\n"
						+ "Ingles: B1-B2 (Medio-Alto)\n"
						+ "\n"
						+ "CONTACTO:\n"
						+ "Correo: wgarciab@unal.edu.co\n"
						+ "Telefono: 3225937769\n"
						+ "Copacabana, Antioquia\n");
			}else if (i2==3){
				//Santiago
				((Label)L).setText("SANTIAGO CANO VASQUES"
						+ "\n"
						+ "SOBRE MI: Soy estudiante de cuarto semestre de Ingenieria de Sistemas\n"
						+ "en la Universidad Nacional de Colombia, sede Medellin."
						+ "\n"
						+ "FORMACIÓN:\n"
						+ "-Bachiller\n"
						+ "   Gimnasio Los Alacazares. Dic.2017\n"
						+ "-Estudiante de Pregrado en Ingenieria de Sistemas e Informatica\n"
						+ "   Universidad Nacional De Colombia, Sede Medellin. Vigente\n"
						+ "\n"
						+ "IDIOMAS:\n"
						+ "Español: Nativo\n"
						+ "Ingles: B1-B2 (Medio-Alto)\n"
						+ "\n"
						+ "CONTACTO:\n"
						+ "Correo: sacanov@unal.edu.co\n"
						+ "Sabaneta, Antioquia\n");
			}else if (i2==4){
				//Keith
				((Label)L).setText("KEITH DAVID KELSY DIAZ"
						+ "\n"
						+ "SOBRE MI: Soy estudiante de segundo año de Ingenieria de Sistemas\n"
						+ " e informática en la Universidad Nacional de Colombia, sede Medellin.\n"
						+ "soy alguien apasionado por la musica, la tecnología y la informatica, he \n"
						+ "participado en algunos proyectos de desarrollo informatico en mi vida academica\n"
						+ "me gusta aprender cada día cosas nuevas por lo que siempre busco alternativas \n"
						+ "de estudio con las que pueda enriquecer mis conocimientos."
						+ "\n"
						+ "FORMACION:\n"
						+ "-Bachiller\n"
						+ "   Escuela Normal Superior Lacides Iriarte Dic.2017\n"
						+ "-Estudiante de Pregrado en Ingenieria de Sistemas e Informática\n"
						+ "   Universidad Nacional De Colombia, Sede Medellin. Vigente\n"
						+ "\n"
						+ "IDIOMAS:\n"
						+ "EspaÃ±ol: Nativo\n"
						+ "Ingles: B1-B2 (Medio-Alto)\n"
						+ "\n"
						+ "CONTACTO:\n"
						+ "Telefono: 3126127024\n"
						+ "Correo: kkelsy@unal.edu.co\n"
						+ "Sahagún, Córdoba\n");
			}
		}
		
	}
	
	//Acciones de OpDeMenu

	class OpIni implements EventHandler<ActionEvent>{
		public void handle(ActionEvent Op) {
			Object op = Op.getSource();
			
			if((((MenuItem)op).getText()).equals("Salir")){
				(new Salir()).ejecutar();
			}else if((((MenuItem)op).getText()).equals("Descripcion")){
				(new Descripcion()).ejecutar();
			}else if((((MenuItem)op).getText()).equals("Iniciar Sesion")) {
				(new Login()).ejecutar();
			}else {
				(new Cliente()).crearUser(1);
			}
			
		}
	}
	
	
	//Main
	//public static void main(String args[]) {
	//	launch(args);
	//}

}
