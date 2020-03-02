package gestorAplicacion.transaccion;

import gestorAplicacion.Asiento;
import gestorAplicacion.Funcion;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tiquete {
	
	static int generarCodigo;
	int codigo;
	Asiento asiento;
	Funcion evento;
	Pago refPago; //codigo del pago
	
	Tiquete (Asiento asiento, Funcion evento, Pago refPago){
		this.codigo = generarCodigo++;
		this.asiento = asiento;
		this.evento = evento;
		this.refPago = refPago;
	}

	public Tiquete() {
		this.codigo = generarCodigo++;
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
			Calendar fechaActual = new GregorianCalendar();
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
