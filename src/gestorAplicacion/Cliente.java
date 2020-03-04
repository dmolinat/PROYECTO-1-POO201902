package gestorAplicacion.users;

import java.util.ArrayList;

import gestorAplicacion.Funcion;

public class Cliente extends User_R {
	Cliente(String nombre, String apellido, String login, String pass, Long document,Integer edad){
		this.nombre=nombre;
		this.apellido=apellido;
		this.login=login;
		this.pass=pass;
		this.document=document;
		this.edad=edad;	
	}

	public String descripTeatro() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Funcion> verF() {
		// TODO Auto-generated method stub
		return null;
	}

}
