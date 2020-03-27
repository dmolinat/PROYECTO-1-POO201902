package gui.errorApp;

public class NotFoundTicketException extends TransactionException{
	
	public NotFoundTicketException() {
		ErrorAplicacionException.getWarning().setContentText("No hay tiquetes disponibles.");
	}
}
