
package gestorAplicacion;

import java.util.ArrayList;

public class Sala {
    private final int numeroID;
    private final int numeroDeSillas;
    private ArrayList<Funcion> programacion;
    public Sala (int id,int sillas){
        this.numeroID = id;
        this.numeroDeSillas = sillas;
    }   
    public int getID(){
        return numeroID;
    }
    public int getSillas(){
        return numeroDeSillas;
    }
}