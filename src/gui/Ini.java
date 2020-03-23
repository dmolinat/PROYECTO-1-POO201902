package gui;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Ini extends Application {
	static int con=2;
	
	@Override
	public void start(Stage stg) throws Exception {
		stg.setTitle("Inicio");
		
		
		
		//Creacion de Panes:
		GridPane P1 = new GridPane();
		GridPane P2 = new GridPane();
		
		P1.setPadding(new Insets(15,15,15,15));
		P1.setPadding(new Insets(15,15,15,15));
		
		GridPane P3 = new GridPane();
		P3.setPrefHeight(150);
		P3.setPrefWidth(150);
		P1.add(P3, 0, 0,4,1);
		
		
		//Imagenes (ImageView)
		GridPane P4 = new GridPane();
		Image image1 = new Image(getClass().getResourceAsStream("/Imagenes/ImT1.png"));
		ImageView ImT1= new ImageView(image1);
		ImT1.setFitHeight(200);
		ImT1.setFitWidth(350);
		//Controlador	
		Label Lim1 = new Label("Teatro:",ImT1);
		Lim1.setFont(new Font("New Times Roman",30));
		P4.add(Lim1, 0, 0,4,1);
		ImEnt M1 = new ImEnt();
		Lim1.setContentDisplay(ContentDisplay.BOTTOM);
		Lim1.setOnMouseEntered(M1);
		
		P4.setPrefHeight(450);
		P4.setPrefWidth(450);
		P1.add(P4, 0, 1,4,1);
		
		//Descripción y saludo
		GridPane P5 = new GridPane();
		Label L2 = new Label("!Bienvenidos a la APP Teatros SA¡"); //Cambiar tipo de letra,fuente,color,etc
		L2.setFont(new Font("New Times Roman",30));
		L2.setTextFill(Color.BLUE);
		
		Label LD = new Label("La aplicación ofrece una serie de herramientas\n"
				+ "para el uso cómodo del usuario que ingrese. En él podrá realizar\n"
				+ "las operaciones necesarias para lograr obtener un tiquete a alguna\n"
				+ "función del usuario de forma satisfactoria. Desde escoger el evento\n"
				+ "con su asiento respectivo, hasta abstenerse de ir con nuestro control\n"
				+ "de reembolsos.");
		P5.add(L2, 0,0,4,1);
		P5.add(LD, 0, 1,4,1);
		P5.setPrefHeight(100);
		P5.setPrefHeight(100);
		P2.add(P5, 0, 0,4,1);
				
		//Hoja de Vida:
		GridPane P6 = new GridPane();
		Label L31= new Label("\n"
				+ "CREADORES:");
		L31.setTextAlignment(TextAlignment.CENTER);
		L31.setTextFill(Color.DARKRED);
		L31.setFont(new Font("New Times Roman",22));
		
		
		P6.add(L31, 3, 0);
		Label L3 = new Label("DENILSON ANDRES MOLINA TRUYOT\n"
				+ "\n"
				+ "SOBRE MI: Soy un estudiante con más dos años cursando la carrera\n"
				+ "de Ing.Sistemas en la Universidad Nacional de Comlombia. Sé desempeñarme\n"
				+  "en los conceptos de estructura de datos y los estándares de eficiencia\n"
				+ "a nivel mundia. Doy lo mejor de mí en los proyectos y he tenido contactos\n"
				+ "con el desarrollo de software y edición de videos bajo ciertas plataformas.\n"
				+ "\n"
				+ "FORMACIÓN:\n"
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
		P2.add(P6, 0, 1,4,1);
		//Oidor de las hojas de vida
		HojClick M2 = new HojClick();
		L3.setOnMouseClicked(M2);
		
		
		//Menu de pantalla de Inicio
		
		
		Scene Vent1 = new Scene(new HBox(P1,P2),950,600);
		stg.setScene(Vent1);
		
		stg.show();
		
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	
	//Cambiar imagenes
	class ImEnt implements EventHandler<MouseEvent>{

		public void handle(MouseEvent event) {
			Object control = event.getSource();
			Image image = new Image(getClass().getResourceAsStream("/Imagenes/ImT" + con + ".png"));
			ImageView Im = new ImageView(image);
			Im.setFitHeight(200);
			Im.setFitWidth(350);
			
			
			((Label)control).setGraphic(Im);
			if (con == 5) {
				con= 0;
			}
			con++;
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
						+ "SOBRE MI: Soy un estudiante con más dos años cursando la carrera\n"
						+ "de Ing.Sistemas en la Universidad Nacional de Comlombia. Sé desempeñarme\n"
						+  "en los conceptos de estructura de datos y los estándares de eficiencia\n"
						+ "a nivel mundia. Doy lo mejor de mí en los proyectos y he tenido contactos\n"
						+ "con el desarrollo de software y edición de videos bajo ciertas plataformas.\n"
						+ "\n"
						+ "FORMACIÓN:\n"
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
						+ " e informática en la Universidad Nacional de Colombia, sede Medellín.\n"
						+ "soy alguien apasionado por la música, la tecnología y la informatica, he \n"
						+ "participado en algunos proyectos de desarrollo informático en mi vida académica\n"
						+ "me gusta aprender cada día cosas nuevas por lo que siempre busco alternativas \n"
						+ "de estudio con las que pueda enriquecer mis conocimientos"
						+ "FORMACIÓN:\n"
						+ "-Bachiller\n"
						+ "   Escuela Normal Superior Lacides Iriarte Dic.2017\n"
						+ "-Estudiante de Pregrado en Ingenieria de Sistemas e Informática\n"
						+ "   Universidad Nacional De Colombia, Sede Medellín. Vigente\n"
						+ "\n"
						+ "IDIOMAS:\n"
						+ "Español: Nativo\n"
						+ "Ingles: B1-B2 (Medio-Alto)\n"
						+ "\n"
						+ "CONTACTO:\n"
						+ "Telefono: 3126127024\n"
						+ "Correo: kkelsy@unal.edu.co\n"
						+ "Sahagún, Córdoba\n");
			}
		}
		
	}

}
