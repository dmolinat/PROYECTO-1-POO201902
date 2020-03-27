package gui.errorApp;

public class ObjetoNoExisteException extends WrongValueException {
	public ObjetoNoExisteException() {
		ErrorAplicacionException.getWarning().setContentText("La cuenta ingresada no ha sido registrada");
	}
}
