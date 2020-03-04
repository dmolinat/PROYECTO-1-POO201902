package gestorAplicacion.users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.SaveObject;
import gestorAplicacion.Funcion;
import uiMain.menuconsola.MenuDeConsola;
import gestorAplicacion.DatosTeatro;

public abstract class User_R implements User{
	private String nombre;
	private String apellido;
	private String login;
	private String pass;
	private String document;
	private Integer edad = 0;
	private String sexo = ""; //M o F
	
	User_R(){
	}
	User_R(String nombre, String apellido, String login, String pass, String document,Integer edad,String sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	User_R(String nombre, String apellido, String login, String pass, String document, Integer edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;
	}
	
	//Crear USUARIO:
	public User_R crearUser(int Op) {
		Scanner in = new Scanner(System.in);
		ArrayList<Object> D = new ArrayList();
		
		String aux;Long aux1; Integer aux2;
			//Ingresar el nombre
		do {
				System.out.print("Ingrese el nombre: "); aux=in.next();
				if(aux.equals("")||aux.contains(" ")) {
					System.out.println("===========================");
					System.out.println("!!ERROR: Nombre invalido　");
					System.out.println("===========================");
					aux=null;
		}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numero　");
					System.out.println("=========================================================");
					aux=null;
				}	
			}while(aux==null);
			D.add(aux);
			
			//Ingresar el apellido
			aux=null;
			do {
				System.out.print("Ingrese el apellido: ");aux=in.next();
				
				if(aux.equals("")||aux.contains(" ")) {
					System.out.println("============================");
					System.out.println("!!ERROR: Apellido invalido　");
					System.out.println("============================");
					aux=null;
				}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numeros　");
					System.out.println("=========================================================");
					aux=null;
				}	
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Login
			aux=null;
			do {
				System.out.print("Ingrese un usuario: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")||existId(aux)||aux.length()<5){
					System.out.println("!!ERROR: Login invalido　");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Pass
			aux=null;
			do {
				System.out.print("Ingrese una contrase馻: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")||aux.length()<6){
					System.out.println("!!ERROR: Login invalido　");
					aux=null;
				}
				
			}while(aux==null);
			D.add(aux);
			
			
			//Ingresar Documento:
			aux=null;
			do {
				System.out.print("Ingrese su Documento: ");
				aux=in.next();
				
				if(aux.equals("")||aux.contains(" ")||!isNumeric(aux)) {
					System.out.println("!!ERROR: Documento Invalido　");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Ingresar edad:
			do {
					
				System.out.print("Ingrese su Edad: ");aux2=in.nextInt();
					
				if(aux2<18) {
					System.out.println("!!ERROR: No eres mayor de edad　");
					aux2=null;
				}
					
				if(aux2>199) {
					System.out.println("!!ERROR: Edad Invalida　");
					aux2=null;
				}
					
			}while(aux2==null);
			D.add(aux2);
			
			//Ingresar Sexo:
			aux=null;
			do {
				System.out.print("Ingrese su sexo: ");aux=in.next();
				if((!aux.equals("M")&&!aux.equals("F"))||aux.equals("")||aux.contains(" ")) {
					System.out.println("!!ERROR: Sexo Invalido　");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			
			SaveObject.Write(SaveObject.U_Cli, D);
			return new Cliente((String) D.get(0),(String)D.get(1),
						(String)D.get(2),(String)D.get(3),(String)D.get(4),
						(Integer)D.get(5));
			
		}
	
	public static String LogIn(String user,String pass) {
		Scanner in = new Scanner(System.in);
		int opc=0;
		
		int indCli=0;
		for(int i=0;i<(DatosTeatro.U).size();i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(user) && (((DatosTeatro.U).get(i)).getPass()).equals(pass)) {
				indCli=i;
			} 
		}
		
		DatosTeatro.userLive = (DatosTeatro.U).get(indCli);
		return "Bienvenido: Has iniciado sesi髇";
	}
	

		
	
	//M閠odo para comprobar que el usuario ya existe.
	
	private boolean existId(String Id) {
		for(int i=0; i < (DatosTeatro.U).size();i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(Id)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumeric(String document) {
		try {
			Integer x = Integer.parseInt(document);
		}catch (NumberFormatException e) {
			return false;
		}	
		return true;
	}
	
	
	//Get y Set
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	
	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login=login;
	}
	
	public String getDocument() {
		return this.document;
	}
	public void setDocument(String document) {
		this.document=document;
	}
	
	public Integer getEdad() {
		return this.edad;
	}
	public void setEdad(Integer edad) {
		this.edad=edad;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo=sexo;
	}
	
}

