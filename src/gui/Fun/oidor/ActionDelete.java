package gui.Fun.oidor;
import gui.Fun.FieldPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class ActionDelete implements EventHandler<ActionEvent>{

	private FieldPanel c = new FieldPanel();
	
	public ActionDelete(FieldPanel c) {
		this.c=c;
	}
	
	public void handle(ActionEvent E) {
		for(int i=0;i<c.getListaCrit().length;i++) {
			((TextField) FieldPanel.getNodeByRowColumnIndex(i+1, 1, FieldPanel.getSoporte())).setText("");
		}
	}

}
