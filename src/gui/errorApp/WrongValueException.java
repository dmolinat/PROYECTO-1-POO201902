package gui.errorApp;

public class WrongValueException extends ErrorAplicacionException{
	private String mensaje = "Error en el guardado de datos";
	public WrongValueException() {
		ErrorAplicacionException.getWarning().setHeaderText("Error en el guardado de datos");
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
