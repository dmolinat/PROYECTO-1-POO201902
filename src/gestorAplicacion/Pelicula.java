package gestorAplicacion;

import java.util.ArrayList;
import java.util.Scanner;


public class Pelicula {
	private static Scanner sc = new Scanner(System.in);
	private String nombre;
	private String genero;
	private String director;
	private int añoLanzamiento;
    public static ArrayList<Pelicula> Cartelera;
    private ArrayList<Funcion> funciones;
    
    public Pelicula(String nombre,String genero,String director,int año){
        this.nombre=nombre;
        this.genero=genero;
        this.director=director;
        this.añoLanzamiento=año;
    }
    public void verInfo(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Genero: "+genero);
        System.out.println("Director: "+director);
        System.out.println("Año de lanzamiento: "+añoLanzamiento);
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
        //verifica si existe esta pelicula en cartelera
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
        //verifica si existe ese numero de funcion
        if (i>=0 && i< funciones.size()){
            return funciones.get(i);
        }
        else{
            return null;
        }
    }
}