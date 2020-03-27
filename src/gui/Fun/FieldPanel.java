package gui.Fun;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FieldPanel extends Pane{
	
	private static GridPane soporte = new GridPane();
	
	private String tituloCriterios;
	private String[] listaCrit;
	private String tituloValores;
	private String[] listaVal;
	private Boolean[] habilitado;
	
	public FieldPanel() {
	}
	
	public FieldPanel(String tituloCriterios,String[] listaCrit ,String tituloValores ,String[] listaVal,Boolean[]habilitado) {
		this.tituloCriterios=tituloCriterios;
		this.listaCrit=listaCrit;
		this.tituloValores=tituloValores;
		this.listaVal=listaVal;
		this.habilitado=habilitado;
		
		if(!soporte.getChildren().isEmpty()) {
			soporte.getChildren().clear();
		}
		
		soporte=new GridPane();
		soporte.setHgap(20);
		soporte.setVgap(10);
		
		Label Titulo = new Label(tituloCriterios);
		Titulo.setFont(new Font("Times New Roman",15));
		Titulo.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		soporte.add(Titulo, 0, 0);
		
		Label Tval = new Label(tituloValores);
		Tval.setFont(new Font("Times New Roman",15));
		Tval.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		soporte.add(Tval, 1, 0);
		
		
		for(int i=0;i<(listaCrit).length;i++) {
			Label l = new Label(listaCrit[i]);
			l.setFont(new Font("Times New Roman",25));
			l.setTextFill(Color.DARKRED);
			soporte.add(l, 0, i+1);
			if(listaVal==null) {
				TextField t = new TextField();
				t.setPrefWidth(300);
				if(!habilitado[i]) {
					t.setEditable(habilitado[i]);
				}
				soporte.add(t, 1, i+1);
			}else {
				for(int j=0;j<listaVal.length;i++) {
					if(listaVal[i]==null) {
						TextField t = new TextField();
						t.setPrefWidth(300);
						if(!habilitado[i]) {
							t.setEditable(habilitado[i]);							
						}
						soporte.add(t, 1, i+1);
					}else {
						TextField t = new TextField(listaVal[i]);
						t.setPrefWidth(300);
						if(!habilitado[i]) {
							t.setEditable(habilitado[i]);
						}
						soporte.add(t, 1, i+1);
					}
				}
			}
		}
	}
	
	public FieldPanel(String tituloCriterios,String[] listaCrit ,String tituloValores ,String[] listaVal) {
		this.tituloCriterios=tituloCriterios;
		this.listaCrit=listaCrit;
		this.tituloValores=tituloValores;
		this.listaVal=listaVal;
		
		if(!soporte.getChildren().isEmpty()) {
			soporte.getChildren().clear();
		}
		
		soporte.setHgap(20);
		soporte.setVgap(10);
		
		Label Titulo = new Label(tituloCriterios);
		Titulo.setFont(new Font("Times New Roman",25));
		Titulo.setBorder(new Border(new BorderStroke(Color.DARKBLUE,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		soporte.add(Titulo, 0, 0);
		
		Label Tval = new Label(tituloValores);
		Tval.setFont(new Font("Times New Roman",25));
		Tval.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
		soporte.add(Tval, 1, 0);
		
		
		for(int i=0;i<(listaCrit).length;i++) {
			Label l = new Label(listaCrit[i]);
			l.setFont(new Font("Times New Roman",25));
			l.setTextFill(Color.DARKRED);
			
			soporte.add(l, 0, i+1);
			if(listaVal==null) {
				TextField t = new TextField();
				t.setPrefWidth(300);
				soporte.add(t, 1, i+1);
			}else {
				for(int j=0;j<listaVal.length;j++) {
					if(listaVal[i]==null) {
						TextField t = new TextField();
						t.setPrefWidth(300);
						soporte.add(t, 1, i+1);
					}else {
						TextField t = new TextField(listaVal[i]);
						t.setPrefWidth(300);
						soporte.add(t, 1, i+1);
					}
				}
			}
		}
	}
	
	public String getValue(String criterio) {
		int fila = 0;
		for(int i=0;i<listaCrit.length;i++) {
			if(listaCrit[i]==criterio) {
				fila=i+1;
			}
		}
		
		Node tf = getNodeByRowColumnIndex(fila,1,FieldPanel.getSoporte());
		return ((TextField) tf).getText();
	}
	
	public static Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();
	    for (Node node : childrens) {
	        if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }
	    return result;
	}
	
	public String getTituloCriterios() {
		return tituloCriterios;
	}

	public void setTituloCriterios(String tituloCriterios) {
		this.tituloCriterios = tituloCriterios;
	}

	public String[] getListaCrit() {
		return listaCrit;
	}

	public void setListaCrit(String[] listaCrit) {
		this.listaCrit = listaCrit;
	}

	public String getTituloValores() {
		return tituloValores;
	}

	public void setTituloValores(String tituloValores) {
		this.tituloValores = tituloValores;
	}

	public String[] getListaVal() {
		return listaVal;
	}

	public void setListaVal(String[] listaVal) {
		this.listaVal = listaVal;
	}

	public Boolean[] getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean[] habilitado) {
		this.habilitado = habilitado;
	}

	public static void setSoporte(GridPane soporte) {
		FieldPanel.soporte = soporte;
	}

	public static GridPane getSoporte() {
		return soporte;
	}
	
	
}
