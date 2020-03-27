package gestorAplicacion.transaccion;

import gestorAplicacion.Asiento;
import gestorAplicacion.Funcion;
import gestorAplicacion.users.Cliente;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tiquete {
	
	private static int generarCodigo=0;
	private int codigo;
	private Asiento asiento;
	private Funcion evento;
	public Pago refPago;//codigo del pago
	private Cliente cliente;
	
	Tiquete (Asiento asiento, Funcion evento, Pago refPago){
		this.asiento = asiento;
		this.evento = evento;
		this.refPago = refPago;
	}

	public Tiquete() {
	}
	
	public static int setGenCodigo() {
		return generarCodigo++;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public Funcion getEvento() {
		return evento;
	}

	public void setEvento(Funcion evento) {
		this.evento = evento;
	}

	public Pago getRefPago() {
		return refPago;
	}

	public void setRefPago(Pago refPago) {
		this.refPago = refPago;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean escogerAsiento(Asiento asiento) {
		if (asiento.isDisponible()) {
			this.setAsiento(asiento);
			asiento.setDisponible(false);
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean cambiarAsiento(Asiento asiento) {
			Date fechaActual = new Date();
			if (this.evento.getFecha().before(fechaActual)) {
				//imprimir el evento ya paso
				return false;
			}
			else {
				if (asiento.isDisponible()) {
					this.asiento.setDisponible(true);
					this.setAsiento(asiento);
					asiento.setDisponible(false);
					return true;
				}
				else {
					return false;
				}
			}
	}
	
}
