package gestorAplicacion.transaccion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pago {
	
	static int generarCodigo;
	int codigo;
	int costoTiquete;
	double costoTotal;
	final double iva = 0.19;
	boolean pagado;
	Tiquete tiquete;
	
	public Pago (int costo, boolean pagado, Tiquete tiquete){
		this.codigo = generarCodigo++;
		this.costoTiquete = costo;
		this.pagado = pagado;
		this.tiquete = tiquete;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCostoTiquete() {
		return costoTiquete;
	}

	public void setCostoTiquete(int costo) {
		this.costoTiquete = costo;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Tiquete getTiquete() {
		return tiquete;
	}

	public void setTiquete(Tiquete tiquete) {
		this.tiquete = tiquete;
	}
	
	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTiquete) {
		this.costoTotal = (costoTiquete) * (1 + iva);
	}

	
	//funciones
	
	public boolean transaccion(Tarjeta_des tarjeta) {
		int valorActual = tarjeta.getValorRecargado();
		if (this.costoTotal > valorActual) {
			//imprimir no tienes saldo suficiente
			return false;
		}
		else {
			tarjeta.setValorRecargado(valorActual - costoTotal);
			this.pagado = true;
			return true;
		}
	}
	
	public boolean reembolso(Tarjeta_des tarjeta) {
		
		Calendar fechaEvento = this.tiquete.getEvento().getFecha();
		Calendar fechaActualMas24 = new GregorianCalendar();
		fechaActualMas24.add(Calendar.DAY_OF_MONTH, 1);
		
		if (fechaEvento.before(fechaActualMas24)) {
			//imprimir faltan 24 horas o menos para el evento. No aplicas para reembolso
			return false;
		}
		else {
			int valorActual = tarjeta.getValorRecargado();
			tarjeta.setValorRecargado(valorActual + this.costoTotal);
			this.tiquete.refPago = null;
			this.tiquete = null;
			//imprimir Reembolso exitoso
			return true;
		}
	}
	
}
