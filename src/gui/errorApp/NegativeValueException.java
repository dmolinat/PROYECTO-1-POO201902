package gui.errorApp;

public class NegativeValueException extends WrongValueException {
	public NegativeValueException() {
		ErrorAplicacionException.getWarning().setContentText("No se pueden ingresar numeros negativos.");
	}
}
