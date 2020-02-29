
package uiMain.menuconsola;
import gestorAplicacion.Funcion;
import gestorAplicacion.Pelicula;
import java.util.Scanner;
import uiMain.OpcionDeMenu;


public class Reservar extends OpcionDeMenu {
    Scanner sc = new Scanner(System.in);
    @Override
    public void mostrar(){
        System.out.print("Reservar ");
    }
    public void ejecutar(){
        verCartelera.verCartelera();
        int sel;
        Pelicula pel = null;
        while (pel == null){
            System.out.println("elija una pelicula");
            sel = sc.nextInt();
            pel = Pelicula.ElegirPelicula(sel);
        }
        System.out.println("elija una funcion");
        if (pel.nroFunciones()==0){
            System.out.println("no hay funciones programadas");
            
            
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
            System.out.println("que funcion desea reservar");
            sel = sc.nextInt();
            funcion = pel.elegirFuncion(sel);
        }
        
    }
}
