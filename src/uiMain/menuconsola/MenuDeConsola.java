package uiMain.menuconsola;
import java.util.ArrayList;

public class MenuDeConsola {
	private ArrayList<OpcionDeMenu> op = new ArrayList();
    
    
    public static void lanzarMenu(ArrayList<OpcionDeMenu> op){
        for (int i=0; i<op.size();i++){
        		System.out.println("Presiona "+ i + "." + "para "+ op.get(i).mostrar());
        }
    }
    
    public ArrayList<OpcionDeMenu> getOp(){
    	return this.op;
    }
    
    public void setOp(ArrayList <OpcionDeMenu> op) {
    	this.op=op;
    }
}
