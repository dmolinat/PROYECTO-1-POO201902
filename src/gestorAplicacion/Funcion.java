
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Date;

public class Funcion {
    Pelicula pelicula;
    Sala sala;
    Date fecha;
    ArrayList<Asiento> asientos;
    public String verPelicula(){
        return pelicula.getNombre();
    }
    public int verSala(){
        return sala.getID();
    }
    public void verFuncion(){
        System.out.println("sala: "+this.verSala());
        System.out.println("Fecha: "+fecha);
    }
    public void verAsientos(){
        System.out.println("asientos disponibles:");
       // falta definirla
        
    }
}
