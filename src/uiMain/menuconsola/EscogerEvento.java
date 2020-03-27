package uiMain.menuconsola;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;
import gui.Fun.FieldPanel;
import gui.Fun.Funcional;
import gui.Fun.oidor.ActionDelete;
import gui.Fun.oidor.ActionSetEvent;
import gui.Fun.oidor.AddDatTextField;
import gui.Fun.oidor.ShowInfoMovie;
import gui.Fun.oidor.ShowInfoMovie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static gestorAplicacion.Pelicula.Cartelera;

import java.util.ArrayList;
import java.util.Scanner;

public class EscogerEvento extends OpcionDeMenu {
	
	private static FieldPanel data;
	public static FieldPanel getData() {
		return data;
	}
	
	private static ComboBox cHor = new ComboBox();
	public static ComboBox getCHor() {
		return cHor;
	}
	
	
    public static void showCartelera(){
        System.out.println("Peliculas en cartelera");
        for(int i=0;i<Pelicula.Cartelera.size();i++){
            System.out.println("Presiona: "+ i + ". Para escoger: " + Pelicula.Cartelera.get(i).getNombre()); 
        }
    }

	@Override
	public void ejecutar() {
		Funcional.getP2().getChildren().clear();
		
		Label nameFun = new Label((new EscogerEvento()).mostrar());
		nameFun.setFont(new Font("Times New Roma",20));
		nameFun.setTextFill(Color.GRAY);
		nameFun.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(nameFun);
		
		Label descripF = new Label("Esta funcionalidad le permite obtener un tiquete." +  
		"\n" + "1. Seleccione una película (pulse Ver Mas para ver los detalles)" + "\n" 
				+ "2. Seleccione uno de los horarios disponibles" + "\n" + "3. Seleccione un asiento" + 
		"\n" + "Finalmente, presione aceptar para generar su tiquete.");
		descripF.setFont(new Font("Times New Roma",20));
		descripF.setTextFill(Color.GRAY);
		descripF.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.DOTTED,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		Funcional.getP2().getChildren().add(descripF);
		
		FieldPanel.getSoporte().getChildren().clear();
		
		data = new FieldPanel("Funcion: ",new String[]{"Pelicula","Sala","Horario","Asiento"},"Valor seleccionado",null,new Boolean[] {false,false,false,false}) ;
		FieldPanel.getSoporte().setBorder(new Border(new BorderStroke(Color.DODGERBLUE,BorderStrokeStyle.DASHED,CornerRadii.EMPTY,
				BorderWidths.DEFAULT)));
		FieldPanel.getSoporte().setAlignment(Pos.CENTER);
		FieldPanel.getSoporte().setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
		Funcional.getP2().getChildren().add(data.getSoporte());
		Funcional.getP2().setAlignment(Pos.CENTER);
		
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
		
		ActionDelete M21 = new ActionDelete(data);
		Delet.setOnAction(M21);
		
		ActionSetEvent M22 = new ActionSetEvent();
		Acep.setOnAction(M22);
		
		Funcional.getP2().getChildren().add(Botons);
		
		//Pelicula
		ComboBox cPel = new ComboBox();
		cPel.setPromptText("PELICULAS:");
		for(int i=0;i<Pelicula.Cartelera.size();i++) {
			String nomP = Pelicula.Cartelera.get(i).getNombre();
			cPel.getItems().add(nomP);
		}
		AddDatTextField M15 = new AddDatTextField();
		cPel.setOnAction(M15);
		
		Button verInfo = new Button("Ver mas...");
		FieldPanel.getSoporte().add(verInfo, 3, 1);
		ShowInfoMovie M16 = new ShowInfoMovie();
		verInfo.setOnAction(M16);
		FieldPanel.getSoporte().add(cPel, 2, 1);
		
		//HORARIO VACIO
		cHor.setPromptText("HORARIO");
		cHor.getItems().add("Seleccione una pelicula...");
		FieldPanel.getSoporte().add(cHor, 2, 3);
		
		/*Scanner sc = new Scanner(System.in);
		Cliente usuario= (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
        EscogerEvento.showCartelera();
        int sel;
        Pelicula pel = null;
        while (pel == null){
            System.out.println("Elija una pelicula");
            sel = sc.nextInt();
            pel = Pelicula.ElegirPelicula(sel);
            if(pel==null) {
            	System.out.println("AVISO: No esta disponible la pelicula seleccionada");
            }
        }
        System.out.println("Elija una funcion");
        if (pel.getFuncions()==null){
            System.out.println("no hay funciones programadas");
            return;
            
            // falta salir de el metodo
        }
        else {
            for (int i=0;i<pel.nroFunciones();i++){
            System.out.println(i);
            System.out.println(pel.getSalas(i));
            System.out.println(pel.getFecha(i));
            }
        } 
        Funcion funcion = null; 
        while(funcion == null){
            System.out.println("¿Qué funcion desea reservar?:");
            sel = sc.nextInt();
            funcion = pel.elegirFuncion(sel);
            if(funcion==null) {
            	System.out.println("AVISO: La funcion seleccionada no se encuentra disponible");
            }
        }
        
 
		Tiquete tiquete = new Tiquete(); //se crea un tiquete
        tiquete.setEvento(funcion); //se le asigna la funcion escogida
		
		System.out.println("Lista de asientos disponibles: ");
		boolean verAsientos = funcion.verAsientosDisponibles();
		if (verAsientos == false) {
			System.out.println("No hay asientos disponibles");
			return;
		}
		
		System.out.println("Escriba el codigo del asiento deseado");
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
			boolean escoger = tiquete.escogerAsiento(asiento);
			if (escoger == true) {
				System.out.println("Asiento elegido correctamente");
				int costo = asiento.getPrecio();
				Pago pago = new Pago(costo, false, tiquete);
				tiquete.setRefPago(pago);
				pago.setCostoTotal(costo);
				tiquete.setEvento(funcion);
				tiquete.setCliente(usuario);
				ArrayList<Tiquete> aux = usuario.getTiquetes();
				aux.add(tiquete);
				usuario.setTiquetes(aux);
				System.out.println("Tiquete generado exitosamente");
			}
			else {
				System.out.println("El asiento no esta disponible");
				return;
			}
			
		}*/
        
    }

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Escoger evento: ";
	}
}