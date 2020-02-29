
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Scanner;


public class Pelicula {
    static Scanner sc = new Scanner(System.in);
    String nombre;
    String genero;
    String director;
    int añoLanzamiento;
    public static ArrayList<Pelicula> Cartelera;
    ArrayList<Funcion> funciones;
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
        return "fecha: " + funciones.get(i).getfecha();
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
