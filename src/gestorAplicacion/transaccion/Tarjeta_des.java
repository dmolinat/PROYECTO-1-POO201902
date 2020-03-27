package gestorAplicacion.transaccion;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import gestorAplicacion.DatosTeatro;
import gestorAplicacion.users.Cliente;

public class Tarjeta_des{
	
	private int codigo;
	
	private double valorRecargado = 0;
	private Calendar fechaDeVencimiento;
	private Calendar fechaDeExpedicion;
	public static int generarCodigoTarjeta;
	private Cliente nombreContribuyente;
	
	public Tarjeta_des(){
		this.codigo = generarCodigoTarjeta++;
		this.valorRecargado = 10000; //se les puede dar un saldo inicial de bienvenida
		this.fechaDeExpedicion = new GregorianCalendar();
		Calendar fechaVen = new GregorianCalendar();
		fechaVen.add(Calendar.YEAR, 2);
		this.fechaDeVencimiento = fechaVen;
		this.nombreContribuyente = (Cliente)DatosTeatro.userLive;//cliente que está loggeado
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int codigo) {
		 this.codigo=codigo;
	}
	public double getValorRecargado() {
		return this.valorRecargado;
	}
	public void setValorRecargado(double valorRecargado) {
		this.valorRecargado=valorRecargado;
	}
	public Date getFechaVen() {
		return this.fechaDeVencimiento.getTime();
	}
	public void setFechaVen(Calendar fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	public Date getFechaExp() {
		return this.fechaDeExpedicion.getTime();
	}
	public void setFechaExp(Calendar fechaDeExpedicion) {
		this.fechaDeExpedicion = fechaDeExpedicion;
	}
	public Cliente getNombreContribuyente() {
		return this.nombreContribuyente;
	}
	public void setNombreContribuyente(String NombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}
}
