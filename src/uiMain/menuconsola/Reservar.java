
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
        Pelicula.verCartelera();
        Pelicula pelicula = Pelicula.ElegirPelicula();
        Funcion funcion = pelicula.elegirFuncion();
    }

}
