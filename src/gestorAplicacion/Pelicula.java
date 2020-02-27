
package gestorAplicacion;

import java.util.ArrayList;
import java.util.Scanner;


public class Pelicula {
    static Scanner sc = new Scanner(System.in);
    String nombre;
    String genero;
    String director;
    int añoLanzamiento;
    static ArrayList<Pelicula> Cartelera;
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
    public static void verCartelera(){
        System.out.println("peliculas en cartelera");
        for(Pelicula i : Cartelera){
            System.err.println(i.getNombre()); 
        }
    }
    public static Pelicula ElegirPelicula(){
        String pelicula = sc.next("elija la pelicula que desea reservar");
        for(Pelicula i : Cartelera){
            if(i.getNombre() == pelicula){
                return i;
            }
            else{
                System.out.println("pelicula incorrecta");
                Pelicula.ElegirPelicula();
            }
        }
        return null;
    }
    public Funcion elegirFuncion(){
        System.out.println("seleccione una funcion");
        if (funciones.size()==0){
            System.out.println("Lo sentimos.No Hay Funciones programadas para esta pelicula");
        }
        else{
            for(int i=1;i<=funciones.size();i++){
                System.out.print(i);
                funciones.get(i-1).verFuncion();
                try {
                    int f = sc.nextInt();
                    if (f>=1 && f<= funciones.size()){
                        return funciones.get(i);
                    }
                    else{
                        System.out.println("valor incorrecto");
                        elegirFuncion();
                    }
                } catch (Exception e) {
                    elegirFuncion();
                }
            }
        }
        return null;
    }
}
