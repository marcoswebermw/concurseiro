package br.mw.conc.view;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import br.mw.conc.controller.PerguntaController;
import br.mw.conc.model.Pergunta;
import br.mw.conc.model.Resposta;

public class ResolucaoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane apCabecalho;

	@FXML
	private AnchorPane apConteudo;

	@FXML
	private AnchorPane apPrincipal;

	// @FXML
	// private Button btnA;
	//
	// @FXML
	// private Button btnB;
	//
	// @FXML
	// private Button btnC;
	//
	// @FXML
	// private Button btnD;
	//
	// @FXML
	// private Button btnE;

	// @FXML
	// private Label lblA;

	@FXML
	private Label lblAcertos;

	@FXML
	private Label lblAno;

	// @FXML
	// private Label lblB;

	@FXML
	private Label lblBanca;

	// @FXML
	// private Label lblC;

	@FXML
	private Label lblCategoria;

	@FXML
	private Label lblCod;

	// @FXML
	// private Label lblD;

	// @FXML
	// private Label lblE;

	@FXML
	private Label lblErros;

	@FXML
	private Label lblNumQuestoes;

	@FXML
	private Label lblProva;

	@FXML
	private Label lblUsuario;

	@FXML
	private Label lblObservacoes;

	@FXML
	private Hyperlink linkAvancar;

	@FXML
	private Hyperlink linkSair;

	@FXML
	private Hyperlink linkA;

	@FXML
	private Hyperlink linkB;

	@FXML
	private Hyperlink linkC;

	@FXML
	private Hyperlink linkD;

	@FXML
	private Hyperlink linkE;

	@FXML
	private TextArea taObservacoes;

	@FXML
	private TextArea taPergunta;

	@FXML
	private TextArea taRespostaA;

	@FXML
	private TextArea taRespostaB;

	@FXML
	private TextArea taRespostaC;

	@FXML
	private TextArea taRespostaD;

	@FXML
	private TextArea taRespostaE;
	
	@FXML
	private VBox vboxLetras;

	// Perguntas a serem respondidas
	private List<Pergunta> perguntasDoBD;

	@FXML
	void initialize() {
		assert apCabecalho != null : "fx:id=\"apCabecalho\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert apConteudo != null : "fx:id=\"apConteudo\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert apPrincipal != null : "fx:id=\"apPrincipal\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert btnA != null :
		// "fx:id=\"btnA\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert btnB != null :
		// "fx:id=\"btnB\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert btnC != null :
		// "fx:id=\"btnC\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert btnD != null :
		// "fx:id=\"btnD\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert btnE != null :
		// "fx:id=\"btnE\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert lblA != null :
		// "fx:id=\"lblA\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkA != null : "fx:id=\"lblA\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblAcertos != null : "fx:id=\"lblAcertos\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblAno != null : "fx:id=\"lblAno\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert lblB != null :
		// "fx:id=\"lblB\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkB != null : "fx:id=\"lblB\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblBanca != null : "fx:id=\"lblBanca\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert lblC != null :
		// "fx:id=\"lblC\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkC != null : "fx:id=\"lblC\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblCategoria != null : "fx:id=\"lblCategoria\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblCod != null : "fx:id=\"lblCod\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert lblD != null :
		// "fx:id=\"lblD\" was not injected: check your FXML file 'resolucao.fxml'.";
		// assert lblE != null :
		// "fx:id=\"lblE\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkD != null : "fx:id=\"lblD\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkE != null : "fx:id=\"lblE\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblObservacoes != null : "fx:id=\"lblErros\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblErros != null : "fx:id=\"lblErros\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblNumQuestoes != null : "fx:id=\"lblNumQuestoes\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblProva != null : "fx:id=\"lblProva\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert lblUsuario != null : "fx:id=\"lblUsuario\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkAvancar != null : "fx:id=\"linkAvancar\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert linkSair != null : "fx:id=\"linkSair\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taObservacoes != null : "fx:id=\"taObservacoes\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taPergunta != null : "fx:id=\"taPergunta\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taRespostaA != null : "fx:id=\"taRespostaA\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taRespostaB != null : "fx:id=\"taRespostaB\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taRespostaC != null : "fx:id=\"taRespostaC\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taRespostaD != null : "fx:id=\"taRespostaD\" was not injected: check your FXML file 'resolucao.fxml'.";
		assert taRespostaE != null : "fx:id=\"taRespostaE\" was not injected: check your FXML file 'resolucao.fxml'.";

		carregarPerguntas();
		mostrarOcultarObs();
		exibirPergunta();
	}

	@FXML
	void avancarPergunta() {
		carregarNovaPergunta();
		redefinirCores();
		linkAvancar.setVisible(false);
		habilitarDesabilitarLetrasRespostas();
	}

	private void habilitarDesabilitarLetrasRespostas() {
		if (!vboxLetras.isDisabled()) {
			vboxLetras.setDisable(true);
		} else {
			vboxLetras.setDisable(false);
		}
	}

	@FXML
	void respostaA() {
		pintarRespostaCerta();
		if (respostaCerta(0)) {
			// lblA.setTextFill(Color.web("#41cc00"));
			linkA.setTextFill(Color.web("#41cc00"));
			acertou();
		} else {
			linkA.setTextFill(Color.web("#000000"));
			errou();
		}
		mostrarOcultarObs();
	}

	@FXML
	void respostaB() {
		pintarRespostaCerta();
		if (respostaCerta(1)) {
			// lblB.setTextFill(Color.web("#41cc00"));
			linkB.setTextFill(Color.web("#41cc00"));
			acertou();
		} else {
			// lblB.setTextFill(Color.web("#000000"));
			linkB.setTextFill(Color.web("#000000"));
			errou();
		}
		mostrarOcultarObs();
	}

	@FXML
	void respostaC() {
		pintarRespostaCerta();
		if (respostaCerta(2)) {
			// lblC.setTextFill(Color.web("#41cc00"));
			linkC.setTextFill(Color.web("#41cc00"));
			acertou();
		} else {
			// lblC.setTextFill(Color.web("#000000"));
			linkC.setTextFill(Color.web("#000000"));
			errou();
		}
		mostrarOcultarObs();
	}

	@FXML
	void respostaD() {
		pintarRespostaCerta();
		if (respostaCerta(3)) {
			// lblD.setTextFill(Color.web("#41cc00"));
			linkD.setTextFill(Color.web("#41cc00"));
			acertou();
		} else {
			// lblD.setTextFill(Color.web("#000000"));
			linkD.setTextFill(Color.web("#000000"));
			errou();
		}
		mostrarOcultarObs();
	}

	@FXML
	void respostaE() {
		pintarRespostaCerta();
		if (respostaCerta(4)) {
			// lblE.setTextFill(Color.web("#41cc00"));
			linkE.setTextFill(Color.web("#41cc00"));
			acertou();
		} else {
			// lblE.setTextFill(Color.web("#000000"));
			linkE.setTextFill(Color.web("#000000"));
			errou();
		}
		mostrarOcultarObs();
	}

	private void errou() {

		linkAvancar.setVisible(true);
	}

	private void acertou() {

		linkAvancar.setVisible(true);
	}

	private void mostrarOcultarObs() {
		if (taObservacoes.isVisible()) {
			taObservacoes.clear();
			taObservacoes.setVisible(false);
			lblObservacoes.setVisible(false);
		} else {
			taObservacoes.setText(perguntasDoBD.get(perguntasDoBD.size() - 1)
					.getTexto());
			taObservacoes.setVisible(true);
			lblObservacoes.setVisible(true);

		}
	}

	// Voltar todos os labels de respostas a cor original.
	private void redefinirCores() {
		// lblA.setTextFill(Color.web("#3385ff"));
		// lblB.setTextFill(Color.web("#3385ff"));
		// lblC.setTextFill(Color.web("#3385ff"));
		// lblD.setTextFill(Color.web("#3385ff"));
		// lblE.setTextFill(Color.web("#3385ff"));
		linkA.setTextFill(Color.web("#3385ff"));
		linkB.setTextFill(Color.web("#3385ff"));
		linkC.setTextFill(Color.web("#3385ff"));
		linkD.setTextFill(Color.web("#3385ff"));
		linkE.setTextFill(Color.web("#3385ff"));
	}

	private void pintarRespostaCerta() {
		int topo = perguntasDoBD.size() - 1;
		List<Resposta> lrespostas = perguntasDoBD.get(topo).getRespostas();
		long respCerta = perguntasDoBD.get(topo).getRespostaCerta();

		if (lrespostas.get(0).getCod() == respCerta)
			// lblA.setTextFill(Color.web("#ff3333"));
			linkA.setTextFill(Color.web("#ff3333"));
		if (lrespostas.get(1).getCod() == respCerta)
			// lblB.setTextFill(Color.web("#ff3333"));
			linkB.setTextFill(Color.web("#ff3333"));
		if (lrespostas.get(2).getCod() == respCerta)
			// lblC.setTextFill(Color.web("#ff3333"));
			linkC.setTextFill(Color.web("#ff3333"));
		if (lrespostas.get(3).getCod() == respCerta)
			// lblD.setTextFill(Color.web("#ff3333"));
			linkD.setTextFill(Color.web("#ff3333"));
		if (lrespostas.get(4).getCod() == respCerta)
			// lblE.setTextFill(Color.web("#ff3333"));
			linkE.setTextFill(Color.web("#ff3333"));

		habilitarDesabilitarLetrasRespostas(); // Desabilita click nos links de
												// respostas.
	}

	// Verifica se é a resposta correta através da posição passada como
	// parâmetro.
	private boolean respostaCerta(int pos) {
		boolean retorno = false;
		int topo = perguntasDoBD.size() - 1;
		long respCerta = perguntasDoBD.get(topo).getRespostaCerta();
		Resposta r = perguntasDoBD.get(topo).getRespostas().get(pos);
		if (r.getCod() == respCerta)
			retorno = true;
		return retorno;
	}

	// Carrega lista de perguntas do banco de dados.
	private void carregarPerguntas() {
		perguntasDoBD = new PerguntaController().listar();
	}

	// Exibe os dados da pergunta na tela.
	private void exibirPergunta() {
		int topo = perguntasDoBD.size() - 1;

		// Rótulos do cabeçalho da pergunta.
		lblCod.setText("Cod.: "
				+ String.valueOf(perguntasDoBD.get(topo).getCod()));
		lblBanca.setText("Banca: " + perguntasDoBD.get(topo).getBanca());
		lblAno.setText("Ano: "
				+ String.valueOf(perguntasDoBD.get(topo).getAno()));
		lblCategoria.setText("Categoria: "
				+ perguntasDoBD.get(topo).getCategoria());
		lblProva.setText("Prova: " + perguntasDoBD.get(topo).getProva());
		// Campos.
		taPergunta.setText(perguntasDoBD.get(topo).getTexto());
		taRespostaA.setText(perguntasDoBD.get(topo).getRespostas().get(0)
				.getTexto());
		taRespostaB.setText(perguntasDoBD.get(topo).getRespostas().get(1)
				.getTexto());
		taRespostaC.setText(perguntasDoBD.get(topo).getRespostas().get(2)
				.getTexto());
		taRespostaD.setText(perguntasDoBD.get(topo).getRespostas().get(3)
				.getTexto());
		taRespostaE.setText(perguntasDoBD.get(topo).getRespostas().get(4)
				.getTexto());
		mostrarOcultarObs();

		linkAvancar.setVisible(false);
	}

	// Remove a ultima pergunta e exibe a próxima.
	// A lista não pode estar vazia.
	private void carregarNovaPergunta() {
		perguntasDoBD.remove(perguntasDoBD.size() - 1);
		if (!perguntasDoBD.isEmpty()) {
			exibirPergunta();
			linkAvancar.setVisible(true);
		}
	}

}
