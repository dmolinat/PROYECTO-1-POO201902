
package uiMain;

import java.util.ArrayList;

public class menuDeConsola {
    ArrayList<OpcionDeMenu> opciones;
    public void añadirOpcion(){
        
    }
    public void lanzarMenu(){
        for (OpcionDeMenu i: opciones){
            i.mostrar();
        }
    }
}
