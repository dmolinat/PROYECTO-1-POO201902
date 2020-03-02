package gestorAplicacion.users;
import java.util.ArrayList;
import java.util.Scanner;
import gestorAplicacion.Funcion;
import gestorAplicacion.DatosTeatro;

public abstract class User_R implements User{
	private String nombre;
	private String apellido;
	private String login;
	private String pass;
	private Long document = new Long(0);
	private Integer edad = 0;
	private String sexo = ""; //M o F
	
	User_R(){
	}
	//Administrador
	User_R(String nombre, String apellido, String login, String pass, Long document,Integer edad,String sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	//Cliente
	User_R(String nombre, String apellido, String login, String pass, Long document, Integer edad){
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
					System.out.println("!!ERROR: Nombre invalido¡¡");
					System.out.println("===========================");
					aux=null;
		}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numero¡¡");
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
					System.out.println("!!ERROR: Apellido invalido¡¡");
					System.out.println("============================");
					aux=null;
				}else if(aux.contains("0")||aux.contains("1")||aux.contains("2")||
						aux.contains("3")||aux.contains("4")||aux.contains("5")||
						aux.contains("6")||aux.contains("7")||aux.contains("8")||
						aux.contains("9")) {
					System.out.println("=========================================================");
					System.out.println("!!ERROR: Los nombres y apellidos no deben llevar numeros¡¡");
					System.out.println("=========================================================");
					aux=null;
				}	
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Login
			aux=null;
			do {
				System.out.print("Ingrese un usuario: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")||existId(aux)){
					System.out.println("!!ERROR: Login invalido¡¡");
					aux=null;
				}
				if(aux.length()<5) {
					System.out.println("¡¡ERROR: No supera el número de caracteres¡¡");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Ingrese Pass
			aux=null;
			do {
				System.out.print("Ingrese una contraseña: ");aux=in.next();
				if(aux.equals("")||aux.contains(" ")){
					System.out.println("!!ERROR: Login invalido¡¡");
					aux=null;
				}
				if(aux.length()<6) {
					System.out.println("¡¡ERROR: No supera el número de caracteres¡¡");
					aux=null;
				}
				
			}while(aux==null);
			D.add(aux);
			
			//Ingresar Documento:
			do {
				System.out.print("Ingrese su Documento: ");
				try {
					aux1=in.nextLong();
				}catch(Exception e) { //Buscar el tipo de error específico
					System.out.println("!!ERROR: Solo se pueden ingresar numeros¡¡ "+e);
					aux1=null;
				}
			}while(aux1==null);
			D.add(aux1);
			
			//Ingresar edad:
			do {
				try {
					
					System.out.print("Ingrese su Edad: ");aux2=in.nextInt();
					
					if(aux2<18) {
						System.out.println("!!ERROR: No eres mayor de edad¡¡");
						aux2=null;
					}
					
					if(aux2>199) {
						System.out.println("!!ERROR: Edad Invalida¡¡");
						aux2=null;
					}
					
				}catch(Exception e) { //Buscar el tipo de error específico
					System.out.println("!!ERROR: Solo se pueden ingresar numeros¡¡");
					aux2=null;
				}
			}while(aux2==null);
			D.add(aux2);
			
			//Ingresar Sexo:
			aux=null;
			do {
				System.out.print("Ingrese su sexo: ");aux=in.next();
				if((!aux.equals("M")&&!aux.equals("F"))||aux.equals("")||aux.contains(" ")) {
					System.out.println("!!ERROR: Sexo Invalido¡¡");
					aux=null;
				}
			}while(aux==null);
			D.add(aux);
			
			//Crear el Admin_System:
			if(Op==1) {
				return new Admin_System((String) D.get(0),(String)D.get(1),
						(String)D.get(2),(String)D.get(3),(Long)D.get(4),
						(Integer)D.get(5),(String)D.get(6));

			}else {
				return new Cliente((String) D.get(0),(String)D.get(1),
						(String)D.get(2),(String)D.get(3),(Long)D.get(4),
						(Integer)D.get(5));
			}
						
			
		//USUARIO CLIENTE	
			
		}
		
	
	//Método para comprobar que el usuario ya existe.
	private boolean existId(String aux) {
		for(int i=0; i < (DatosTeatro.U).size();i++) {
			if((((DatosTeatro.U).get(i)).getLogin()).equals(aux)) {
				return true;
			}
		}
		return false;
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
	
	public Long getDocument() {
		return this.document;
	}
	public void setDocument(Long document) {
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
