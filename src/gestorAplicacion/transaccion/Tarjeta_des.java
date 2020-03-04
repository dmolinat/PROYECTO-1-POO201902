package gestorAplicacion.transaccion;
import java.util.date;
import gestorAplicacion.users.Cliente;

public class Tarjeta_des{
	
	int codigo;
	double valorRecargado = 0;
	java.util.date fechaDeVencimiento = new Date();
	java.util.date fechaDeExpedicion = new Date();
	Cliente nombreContribuyente;
	public Tarjeta_des() {}
	public Tarjeta_des(double valorRecargado, int codigo, Date fechaDeVencimiento, Date fechaDeExpedicion, Cliente nombreContribuyente) {
		this.valorRecargado = valorRecargado;
		this.codigo = codigo;
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.fechaDeExpedicion = fechaDeExpedicion;
		this.nombreContribuyente = nombreContribuyente;
}
	public Integer getCodigo() {
		return this.codigo;
	}
	public void setCodigo(String codigo) {
		 this.codigo=codigo;
	}
	public double getValorRecargado() {
		return this.valorRecargado;
	}
	public void setValorRecargado(double valorRecargado) {
		this.valorRecargado=valorRecargado;
	}
	public Date getFechaVen() {
		return this.fechaDeVencimiento;
	}
	public void setFechaVen(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	public Date getFechaExp() {
		return this.fechaDeExpedicion;
	}
	public void setFechaExp(Date fechaDeExpedicion) {
		this.fechaDeExpedicion = fechaDeExpedicion;
	}
	public String getNombreContribuyente() {
		return this.nombreContribuyente;
	}
	public void setNombreContribuyente(String NombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;
	}
