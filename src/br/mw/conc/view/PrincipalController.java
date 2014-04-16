package br.mw.conc.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnGerenciarPergResp;

	@FXML
	private Button btnRemover;

	@FXML
	private Button btnRespQuestoes;

	@FXML
	private Button btnSair;

	@FXML
	private Label lblMensagem;

	@FXML
	private ListView<?> lstvUsuarios;

	@FXML
	private TextField tfUsuario;

	@FXML
	void getAdicionar(ActionEvent event) {
	}

	@FXML
	void getGerenciarPerguntasRespostas(ActionEvent event) {
		chamarTela("./Cadastro.fxml");
	}

	@FXML
	void getRemover(ActionEvent event) {
	}

	@FXML
	void getSair(ActionEvent event) {
	    // Obter o stage a partir de um componente dele. 
		// No caso o botão btnGerenciarPergResp.
	    Stage stage = (Stage) btnGerenciarPergResp.getScene().getWindow();
	    stage.close();		
	}

	@FXML
	void getTelaQuestoes(ActionEvent event) {
		chamarTela("./Resolucao.fxml");
	}

	@FXML
	void initialize() {
		// assert btnAdicionar != null :
		// "fx:id=\"btnAdicionar\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert btnGerenciarPergResp != null :
		// "fx:id=\"btnGerenciarPergResp\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert btnRemover != null :
		// "fx:id=\"btnRemover\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert btnRespQuestoes != null :
		// "fx:id=\"btnRespQuestoes\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert btnSair != null :
		// "fx:id=\"btnSair\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert lblMensagem != null :
		// "fx:id=\"lblMensagem\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert lstvUsuarios != null :
		// "fx:id=\"lstvUsuarios\" was not injected: check your FXML file 'Principal.fxml'.";
		// assert tfUsuario != null :
		// "fx:id=\"tfUsuario\" was not injected: check your FXML file 'Principal.fxml'.";

	}

	private void chamarTela(String tela) {
		URL arquivoFXML = getClass().getResource(tela);
		Parent fxmlParent;
		try {
			fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			Stage palco = new Stage();
			palco.setScene(new Scene(fxmlParent));
			palco.setTitle("Concurseiro");
			palco.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
