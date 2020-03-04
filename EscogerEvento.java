package uiMain.menuconsola;

import gestorAplicacion.Asiento;
import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import gestorAplicacion.transaccion.Pago;
import gestorAplicacion.transaccion.Tiquete;
import gestorAplicacion.users.Cliente;

import static gestorAplicacion.Pelicula.Cartelera;

import java.util.ArrayList;
import java.util.Scanner;

public class EscogerEvento extends OpcionDeMenu {
	
    public static void showCartelera(){
        System.out.println("Peliculas en cartelera");
        for(int i=0;i<Pelicula.Cartelera.size();i++){
            System.out.println("Presiona: "+ i + ". Para escoger: " + Pelicula.Cartelera.get(i).getNombre()); 
        }
    }

	@Override
	public void ejecutar() {
		Scanner sc = new Scanner(System.in);
		Cliente usuario= (Cliente) DatosTeatro.userLive; //esta variable hay que apuntarla al usuario que este loggeado
		
        EscogerEvento.showCartelera();
        int sel;
        Pelicula pel = null;
        while (pel == null){
            System.out.println("Elija una pelicula");
            sel = sc.nextInt();
            pel = Pelicula.ElegirPelicula(sel);
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
			
		}
        
    }

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return "Escoger evento: ";
	}
}