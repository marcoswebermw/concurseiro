package br.mw.conc.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import br.mw.conc.controller.PerguntaController;
import br.mw.conc.model.Pergunta;

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
		chamarTela("/br/mw/conc/view/Cadastro.fxml");
	}

	@FXML
	void getRemover(ActionEvent event) {
	}

	@FXML
	void getSair(ActionEvent event) {
		// Obter o stage a partir de um componente dele.
		// No caso o botÃ£o btnGerenciarPergResp.
		Stage stage = (Stage) btnGerenciarPergResp.getScene().getWindow();
		stage.close();
	}

	@FXML
	void getTelaQuestoes(ActionEvent event) {
		if (bdEstaVazio()) {
			lblMensagem.setText("Adicione alguma pergunta antes de começar!");
		} else {
			lblMensagem.setText("");
			chamarTela("/br/mw/conc/view/Resolucao.fxml");
		}
	}

	@FXML
	void initialize() {
		lblMensagem.setText("");
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

	private boolean bdEstaVazio() {
		boolean retorno = false;
		List<Pergunta> perguntas = new PerguntaController().listar();
		if (perguntas == null || perguntas.size() <= 0)
			retorno = true;
		return retorno;
	}

}
