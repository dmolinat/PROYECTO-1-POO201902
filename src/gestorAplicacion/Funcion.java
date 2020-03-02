
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Date;

public class Funcion {
    Pelicula pelicula;
    Sala sala;
    Calendar fecha;
    ArrayList<Asiento> asientos;
    public String verPelicula(){
        return pelicula.getNombre();
    }
    public int getSala(){
        return sala.getID();
    }
    public Calendar getfecha(){
        return fecha;
    }
    public ArrayList<Asiento> getAsientos(){
       return asientos;
        
    }
    
    public Asiento buscarAsiento(String codigo) {
		Iterator<Asiento> iterador = asientos.iterator();
		while(iterador.hasNext()) {
			Asiento asiento = (Asiento) iterador.next();
			if (asiento.codigo.equals(codigo)) {
				return asiento;
			}
		}
		return null;
	}
    
    public boolean verAsientosDisponibles() {
    	int contador = 0;
    	Iterator<Asiento> iterador = asientos.iterator();
		while(iterador.hasNext()) {
			Asiento asiento = (Asiento) iterador.next();
			if (asiento.disponible == true) {
				System.out.println(asiento.codigo);
				contador++;
			}
		}
		if (contador > 0) {
			return true; //hay asientos disponibles
		}
		else {
			return false; //no hay asientos disponibles
		}
    }
}
