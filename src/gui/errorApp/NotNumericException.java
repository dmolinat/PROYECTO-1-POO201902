package gui.errorApp;

public class NotNumericException extends WrongValueException {
	public NotNumericException() {
		ErrorAplicacionException.getWarning().setContentText("El dato ingresado no es NUMERICO");
	}
}
