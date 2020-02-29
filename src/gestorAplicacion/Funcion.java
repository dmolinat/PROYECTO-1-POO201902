
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
    public int getSala(){
        return sala.getID();
    }
    public Date getfecha(){
        return fecha;
    }
    public void getAsientos(){
       // falta definirla
        
    }
}
