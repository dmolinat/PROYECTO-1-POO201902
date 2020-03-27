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
	

	
	public Tiquete getTiqueteWithCodigo(int cod) {
		for(int i=0; i<Tiquetes.size();i++) {
			int auxCod = Tiquetes.get(i).getCodigo();
			if(auxCod==cod) {
				return Tiquetes.get(i);
			}
		}
		return new Tiquete();
	}
	public ArrayList<Integer> mostrarTiquetesSinPagar() {
		Iterator<Tiquete> iterador = Tiquetes.iterator();
		ArrayList<Integer> cods = new ArrayList();
		
		while (iterador.hasNext()) {
			Tiquete tiquete = iterador.next();
			if(!tiquete.getRefPago().isPagado()) {
				//System.out.println("=== Deudas pendientes: ===");
				cods.add(tiquete.getCodigo());
				/*System.out.println("Fecha: " + tiquete.getEvento().getFecha().getTime());
				System.out.println("Pelicula: " + tiquete.getEvento().verPelicula());
				System.out.println("Asiento: " + tiquete.getAsiento().getCodigo());*/
			}/*else {
				System.out.println("=== Tiquetes pagados: ===");
				System.out.println(contador++ + ". " + " Codigo: " + tiquete.getCodigo());
				System.out.println("Fecha: " + tiquete.getEvento().getFecha().getTime());
				System.out.println("Pelicula: " + tiquete.getEvento().verPelicula());
				System.out.println("Asiento: " + tiquete.getAsiento().getCodigo());
			}*/
		}
		return cods;
	}
	
	public ArrayList<Integer> mostrarTicketsPag(){
		Iterator<Tiquete> iterador = Tiquetes.iterator();
		ArrayList<Integer> cods = new ArrayList();
		while (iterador.hasNext()) {
			Tiquete tiquete = iterador.next();
			if(tiquete.getRefPago().isPagado()) {
				//System.out.println("=== Deudas pendientes: ===");
				cods.add(tiquete.getCodigo());
				/*System.out.println("Fecha: " + tiquete.getEvento().getFecha().getTime());
				System.out.println("Pelicula: " + tiquete.getEvento().verPelicula());
				System.out.println("Asiento: " + tiquete.getAsiento().getCodigo());*/
			}/*else {
				System.out.println("=== Tiquetes pagados: ===");
				System.out.println(contador++ + ". " + " Codigo: " + tiquete.getCodigo());
				System.out.println("Fecha: " + tiquete.getEvento().getFecha().getTime());
				System.out.println("Pelicula: " + tiquete.getEvento().verPelicula());
				System.out.println("Asiento: " + tiquete.getAsiento().getCodigo());
			}*/
		}
		return cods;
	}
	
	
	
	public Tiquete seleccionarTiquete(int indice) {
		try {
			return Tiquetes.get(indice);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
		
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
