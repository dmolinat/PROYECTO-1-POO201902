package gui.errorApp;

public class TransactionException extends ErrorAplicacionException {
	public TransactionException() {
		ErrorAplicacionException.getWarning().setHeaderText("Error en la TRANSACCION.");;
	}
}
