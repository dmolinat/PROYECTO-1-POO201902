package gui.Fun.oidor;
import gui.Fun.Funcional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import uiMain.menuconsola.CambiarAsiento;
import uiMain.menuconsola.EscogerEvento;
import uiMain.menuconsola.PagarTiquete;
import uiMain.menuconsola.RecargarTarjetad;
import uiMain.menuconsola.Reembolso;

public class ActionMenuFuncion implements EventHandler<ActionEvent>{

	public void handle(ActionEvent E) {
		Object menuItem = E.getSource();
		String nom = ((MenuItem)menuItem).getText();
		
		if(nom.equals((new EscogerEvento()).mostrar())) {
			(new EscogerEvento()).ejecutar();
			Funcional.setScene();
		}else if(nom.equals(new PagarTiquete().mostrar())){
			(new PagarTiquete()).ejecutar();
			Funcional.setScene();
		}else if(nom.equals(new Reembolso().mostrar())){
			(new Reembolso()).ejecutar();
			Funcional.setScene();
		}else if(nom.equals(new CambiarAsiento().mostrar())){
			(new CambiarAsiento()).ejecutar();
			Funcional.setScene();
		}else if(nom.equals(new RecargarTarjetad().mostrar())){
			(new RecargarTarjetad()).ejecutar();
			Funcional.setScene();
		}
		
	}

}
