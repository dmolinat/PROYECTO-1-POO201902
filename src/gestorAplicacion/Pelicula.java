package gestorAplicacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Pelicula {
	private static Scanner sc = new Scanner(System.in);
	private String nombre;
	private String genero;
	private String director;
	private Integer añoLanzamiento;
    public static ArrayList<Pelicula> Cartelera = new ArrayList();
    private ArrayList<Funcion> funciones;
    
    public Pelicula(String nombre,String genero,String director,Integer año){
        this.nombre=nombre;
        this.genero=genero;
        this.director=director;
        this.añoLanzamiento=año;
    }
    
    public static Pelicula getPeliWithName(String name) {
    	for(int i=0;i<Cartelera.size();i++) {
    		Pelicula P = Cartelera.get(i);
    		String Np = P.getNombre();
    		if(Np.equals(name)) {
    			return P;
    		}
    	}
    	return null;
    }
    
    
    public static int getSalaWithNameAndDate(String name,String Date) {
    	Pelicula P = null;
    	for(int i=0;i<Cartelera.size();i++) {
    		P = Cartelera.get(i);
    		String Np = P.getNombre();
    		if(Np.equals(name)) {
    			break;
    		}
    	}
    	ArrayList<Funcion> aux = P.getFuncions();
    	for(int j=0; j<P.getFuncions().size();j++) {
    		
    		String fecha1 = Date.substring(7);	
    		String f2 = ""+aux.get(j).getFecha1();
    		
    		
    		if(f2.trim().equals(fecha1.trim())) {
    			return aux.get(j).getSala();
    		}
    	}
    	return -1;
    }
    
    public static ArrayList<Asiento> getAsientosWithNameAndDate(String name,String Date){
    	Pelicula P = null;
    	for(int i=0;i<Cartelera.size();i++) {
    		P = Cartelera.get(i);
    		String Np = P.getNombre();
    		if(Np.equals(name)) {
    			break;
    		}
    	}
    	
    	ArrayList<Funcion> aux = P.getFuncions();
    	for(int j=0; j<P.getFuncions().size();j++) {
    		
    		String fecha1 = Date.substring(7);	
    		String f2 = ""+aux.get(j).getFecha1();
    		
    		
    		if(f2.trim().equals(fecha1.trim())) {
    			return aux.get(j).getAsientos();
    		}
    	}
    	return new ArrayList<Asiento>();
    }
    
    public String getGenero() {
    	return this.genero;
    }
    
    public String getDirector() {
    	return this.director;
    }
    public Integer getAñoLanzamiento() {
    	return this.añoLanzamiento;
    }
    
    public String verInfo(){
        return "Nombre: "+nombre + " Genero: "+ genero + " Director: "+director + " Año de lanzamiento: "+añoLanzamiento;
    }
    public String getNombre(){
        return nombre;
    }
    public void enCartelera(){
        Cartelera.add(this);
    }
    public void fuera(){
        Cartelera.remove(this);
    }
    
    public static Pelicula ElegirPelicula(int i){
        if (i>=0 && i< Cartelera.size()){
            return Cartelera.get(i);
        } 
        return null;
    }
    public int nroFunciones(){
        return funciones.size();
    }
    public String getSalas(int i){
        return "sala: " + funciones.get(i).getSala();
    }
    public String getFecha(int i){
        return "fecha: " + funciones.get(i).getFecha1();
    }
    
    public ArrayList<Funcion> getFuncions(){
    	return funciones;
    }
    public void setFuncions(ArrayList<Funcion>funciones){
    	this.funciones=funciones;
    }
    
    public Funcion elegirFuncion(int i){
        if (i>=0 && i< funciones.size()){
            return funciones.get(i);
        }
        else{
            return null;
        }
    }
}
