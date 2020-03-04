
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

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
	
	public void anadirAsientos() {
    	ArrayList<String> privados = new ArrayList<String>(Arrays.asList("A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9"));
    	ArrayList<String> comunes = new ArrayList<String>(Arrays.asList("C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "G0", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "H0", "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9"));
    	for (int i = 0; i < privados.size(); i++) {
    		Asiento asientoNuevo = new Asiento(privados.get(i), 10000, true);
    		this.getAsientos().add(asientoNuevo);
    	}
    	for (int i = 0; i < comunes.size(); i++) {
    		Asiento asientoNuevo = new Asiento(comunes.get(i), 5000, true);
    		this.getAsientos().add(asientoNuevo);
    	}
    }

}

