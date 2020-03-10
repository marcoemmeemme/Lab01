package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtTempo;
    
    @FXML
    void doInsert(ActionEvent event) {
    	String parola=txtParola.getText();
    	elenco.addParola(parola);
    	List<String> listaParole=elenco.getElenco();
    	txtResult.clear();
    	for(String p:listaParole)
    	{
    		txtResult.appendText(p+"\n");
    	}
    	this.doTime(event);
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    	this.doTime(event);
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	String parola=txtParola.getText();
    	elenco.elimina(parola);
    	List<String> listaParole=elenco.getElenco();
    	txtResult.clear();
    	for(String p:listaParole)
    	{
    		txtResult.appendText(p+"\n");
    	}
    	this.doTime(event);
    }
    
    @FXML
    void doTime(ActionEvent event) {
    	txtTempo.clear();
    	long tempoEs=System.nanoTime();
    	txtTempo.appendText(String.valueOf(tempoEs));
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
