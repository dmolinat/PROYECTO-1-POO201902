
package uiMain.menuconsola;

import gestorAplicacion.Pelicula;
import static gestorAplicacion.Pelicula.Cartelera;


public class verCartelera {
    public static void verCartelera(){
        System.out.println("peliculas en cartelera");
        for(int i=0;i<Pelicula.Cartelera.size();i++){
            System.out.println(i + ". " + Pelicula.Cartelera.get(i).getNombre()); 
        }
    }
}
