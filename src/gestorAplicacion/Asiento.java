package gestorAplicacion;

public class Asiento {

	private String codigo;
	private int precio;
	private boolean disponible = true;

	Asiento (String codigo, int precio, boolean disponible){
		this.codigo = codigo;
		this.precio = precio;
		this.disponible = disponible;
	}

	//setter y getters

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
		
	}


}

