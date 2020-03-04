package gestorAplicacion.Transaccion;
import java.util.date;

public class Tarjeta_des{	
	Integer codigo;
	java.util.date fechaDeVencimiento = new Date();
	java.util.date fechaDeExpedicion = new Date();
	String nombreContribuyente;
	public Tarjeta_des() {}
	public Tarjeta_des(Integer codigo, Date fechaDeVencimiento, Date fechaDeExpedicion,String nombreContribuyente) {
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
		return this.nombre;
	}
	public void setNombreContribuyente(String NombreContribuyente) {
		this.nombreContribuyente = nombreContribuyente;;
	}
