package gestorAplicacion.users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.Funcion;
import gestorAplicacion.transaccion.Tarjeta_des;
import gestorAplicacion.transaccion.Tiquete;
import uiMain.menuconsola.MenuDeConsola;
import uiMain.menuconsola.OpcionDeMenu;

public class Cliente extends User_R {
	
	private ArrayList<Tiquete> Tiquetes = new ArrayList();
	//Añadir todas las opciones de menu que existan, pero el Cliente solo podrá
	//acceder a las que estén con available=true
	private Tarjeta_des tarjeta;
	private MenuDeConsola MenCli = new MenuDeConsola();
	
	
	public Cliente() {	
	}
	
	public Cliente(String nombre,String apellido,String login,String pass, String document, Integer edad) {
		super(nombre,apellido,login,pass,document,edad);
		tarjeta = new Tarjeta_des();
		MenCli.setOp(DatosTeatro.opCli);
	}
	public String descripTeatro() {
		String a = DatosTeatro.Descripcion;
		return a;
	}
	
	public void Opci() {
		Scanner in = new Scanner(System.in);
			int op=0;
			do {
				MenuDeConsola.lanzarMenu(((Cliente)DatosTeatro.userLive).getMenCli().getOp());
				System.out.println("Presiona "+ ((Cliente)DatosTeatro.userLive).getMenCli().getOp().size() + ": Para salir");
				op=in.nextInt();
				
				if(op!=((Cliente)DatosTeatro.userLive).getMenCli().getOp().size()) {
					((Cliente)DatosTeatro.userLive).getMenCli().getOp().get(op).ejecutar();
				}
			}while(op!=((Cliente)DatosTeatro.userLive).getMenCli().getOp().size());	
	}
	
	
	
	public MenuDeConsola getMenCli(){
		return this.MenCli;
	}
	

	
	
	public void mostrarTiquetes() {
		int contador = 0;
		Iterator<Tiquete> iterador = Tiquetes.iterator();
		while (iterador.hasNext()) {
			Tiquete tiquete = iterador.next();
			System.out.println(contador++ + ". " + " Codigo: " + tiquete.getCodigo());
			System.out.println("Fecha: " + tiquete.getEvento().getFecha().getTime());
			System.out.println("Pelicula: " + tiquete.getEvento().verPelicula());
			System.out.println("Asiento: " + tiquete.getAsiento().getCodigo());
		}
	}
	
	public Tiquete seleccionarTiquete(int indice) {
		return Tiquetes.get(indice);
	}

	public ArrayList<Tiquete> getTiquetes() {
		return Tiquetes;
	}
	
	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.Tiquetes=tiquetes;
	}
	
	public Tarjeta_des getAfiliacion() {
		return tarjeta;
	}
	
	public void RecargarTarjeta(double val) {
		tarjeta.setValorRecargado(tarjeta.getValorRecargado()+val);
	}

}
