package uiMain.menuconsola;

import gestorAplicacion.DatosTeatro;

public class ShowOpc extends OpcionDeMenu {

	@Override
	public void ejecutar() {
		System.out.println("Opciones");
		for(int i=0; i < DatosTeatro.opCli.size();i++) {
			System.out.println("-"+DatosTeatro.opCli.get(i).mostrar());
		}

	}
	@Override
	public String mostrar() {
		return "Mostrar todas las opciones del sistema: ";
	}

}
