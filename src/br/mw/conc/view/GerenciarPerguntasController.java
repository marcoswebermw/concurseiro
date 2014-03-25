package br.mw.conc.view;

/**
 * Sample Skeleton for "cadastro.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import br.mw.conc.controller.PerguntaController;
import br.mw.conc.controller.RespostaController;
import br.mw.conc.model.Pergunta;
import br.mw.conc.model.PerguntaProperty;
import br.mw.conc.model.PerguntaRespostas;
import br.mw.conc.model.PerguntaRespostasFactory;
import br.mw.conc.model.Resposta;
import br.mw.conc.util.AuxiliarTela;
import br.mw.conc.util.ValidacaoFormulario;

import com.sun.javafx.scene.control.Logging;

public class GerenciarPerguntasController {
	@FXML
	// ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	// URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML
	// fx:id="btnDeletar"
	private Button btnDeletar; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnNova"
	private Button btnNova; // Value injected by FXMLLoader

	@FXML
	// fx:id="btnSalvar"
	private Button btnSalvar; // Value injected by FXMLLoader

	@FXML
	// fx:id="detalhes"
	private AnchorPane detalhes; // Value injected by FXMLLoader

	@FXML
	// fx:id="grupoCabPergResp"
	private Group grupoCabPergResp; // Value injected by FXMLLoader

	@FXML
	// fx:id="grupoCabecalho"
	private Group grupoCabecalho; // Value injected by FXMLLoader

	@FXML
	// fx:id="grupoPerguntasRespostas"
	private Group grupoPerguntasRespostas; // Value injected by FXMLLoader

	@FXML
	// fx:id="hboxBotoes"
	private HBox hboxBotoes; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblAno"
	private Label lblAno; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblBanca"
	private Label lblBanca; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblCategoria"
	private Label lblCategoria; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblCod"
	private Label lblCod; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblObservacoes"
	private Label lblObservacoes; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblPergunta"
	private Label lblPergunta; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblRespostaA"
	private Label lblRespostaA; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblRespostaB"
	private Label lblRespostaB; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblRespostaC"
	private Label lblRespostaC; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblRespostaD"
	private Label lblRespostaD; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblRespostaE"
	private Label lblRespostaE; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblCategoriaErro"
	private Label lblCategoriaErro;

	@FXML
	// fx:id="lblBancaErro"
	private Label lblBancaErro;

	@FXML
	// fx:id="lblAnoErro"
	private Label lblAnoErro;

	@FXML
	// fx:id="lblPerguntaErro"
	private Label lblPerguntaErro;

	@FXML
	// fx:id="lblRespostaAErro"
	private Label lblRespostaAErro;

	@FXML
	// fx:id="lblRespostaBErro"
	private Label lblRespostaBErro;

	@FXML
	// fx:id="lblRespostaCErro"
	private Label lblRespostaCErro;

	@FXML
	// fx:id="lblRespostaDErro"
	private Label lblRespostaDErro;

	@FXML
	// fx:id="lblRespostaEErro"
	private Label lblRespostaEErro;

	@FXML
	// fx:id="lblRespostaCertaErro"
	private Label lblRespostaCertaErro;

	@FXML
	// fx:id="lblMensagem"
	private Label lblMensagem;

	@FXML
	// fx:id="perguntas"
	private TableView<PerguntaProperty> perguntas; // Value injected by
													// FXMLLoader

	@FXML
	// fx:id="rbRespostaA"
	private RadioButton rbRespostaA; // Value injected by FXMLLoader

	@FXML
	// fx:id="rbRespostaB"
	private RadioButton rbRespostaB; // Value injected by FXMLLoader

	@FXML
	// fx:id="rbRespostaC"
	private RadioButton rbRespostaC; // Value injected by FXMLLoader

	@FXML
	// fx:id="rbRespostaD"
	private RadioButton rbRespostaD; // Value injected by FXMLLoader

	@FXML
	// fx:id="rbRespostaE"
	private RadioButton rbRespostaE; // Value injected by FXMLLoader

	@FXML
	// fx:id="respostaCorreta"
	private ToggleGroup respostaCorreta; // Value injected by FXMLLoader

	@FXML
	// fx:id="taObservacoes"
	private TextArea taObservacoes; // Value injected by FXMLLoader

	@FXML
	// fx:id="taPergunta"
	private TextArea taPergunta; // Value injected by FXMLLoader

	@FXML
	// fx:id="taRespostaA"
	private TextArea taRespostaA; // Value injected by FXMLLoader

	@FXML
	// fx:id="taRespostaB"
	private TextArea taRespostaB; // Value injected by FXMLLoader

	@FXML
	// fx:id="taRespostaC"
	private TextArea taRespostaC; // Value injected by FXMLLoader

	@FXML
	// fx:id="taRespostaD"
	private TextArea taRespostaD; // Value injected by FXMLLoader

	@FXML
	// fx:id="taRespostaE"
	private TextArea taRespostaE; // Value injected by FXMLLoader

	@FXML
	// fx:id="tfAno"
	private TextField tfAno; // Value injected by FXMLLoader

	@FXML
	// fx:id="tfBanca"
	private TextField tfBanca; // Value injected by FXMLLoader

	@FXML
	// fx:id="tfCategoria"
	private TextField tfCategoria; // Value injected by FXMLLoader

	@FXML
	// fx:id="tfCod"
	private TextField tfCod; // Value injected by FXMLLoader

	// Handler for Button[fx:id="btnNova"] onAction
	@FXML
	void novaPergunta(ActionEvent event) {
		limparControles();
		AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
		mostrarOcultarControles();
		Logging.getControlsLogger().info("Executou Método ->  novaPergunta()");
	}

	// Handler for Button[fx:id="btnSalvar"] onAction
	@FXML
	void salvarPergunta(ActionEvent event) {
		boolean categoriaErro = ValidacaoFormulario.campoPreenchido(
				tfCategoria, lblCategoriaErro, "Preencha a categoria!");
		boolean bancaErro = ValidacaoFormulario.campoPreenchido(tfBanca,
				lblBancaErro, "Preencha a banca!");
		boolean anoErro = ValidacaoFormulario.campoAnoPreenchidoCorretamente(tfAno,
				lblAnoErro, "Preencha o ano!");
		boolean perguntaErro = ValidacaoFormulario.campoPreenchido(taPergunta,
				lblPerguntaErro, "Preencha a pergunta!");
		boolean respostaAErro = ValidacaoFormulario.campoPreenchido(
				taRespostaA, lblRespostaAErro, "Preencha a resposta A!");
		boolean respostaBErro = ValidacaoFormulario.campoPreenchido(
				taRespostaB, lblRespostaBErro, "Preencha a resposta B!");
		boolean respostaCErro = ValidacaoFormulario.campoPreenchido(
				taRespostaC, lblRespostaCErro, "Preencha a resposta C!");
		boolean respostaDErro = ValidacaoFormulario.campoPreenchido(
				taRespostaD, lblRespostaDErro, "Preencha a resposta D!");
		boolean respostaEErro = ValidacaoFormulario.campoPreenchido(
				taRespostaE, lblRespostaEErro, "Preencha a resposta E!");
		boolean respostaCertaErro = ValidacaoFormulario.respostaMarcada(
				respostaCorreta, lblRespostaCertaErro, "Marque uma resposta!");

		// Validando Campos, Salvando ou Alterando Pergunta e Suas Respostas.
		String msg = null;
		if (categoriaErro && bancaErro && anoErro && perguntaErro
				&& respostaAErro && respostaBErro && respostaCErro
				&& respostaDErro && respostaEErro && respostaCertaErro) {
			if (tfCod.equals(null) || tfCod.getText().equals("".trim())) {
				salvarDados();
				msg = "Pergunta salva corretamente!";
			} else {
				alterarDados();
				msg = "Pergunta alterada corretamente!";
			}

			limparControles();
			AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
			mostrarOcultarControles();
		}
		AuxiliarTela.mostrarMensagem(msg, lblMensagem);
		Logging.getControlsLogger()
				.info("Executou Método ->  salvarPergunta()");
	}

	// Handler for Button[fx:id="btnDeletar"] onAction
	@FXML
	void deletarPergunta(ActionEvent event) {
		String msg = "Pergunta excluída corretamente!";
		if (perguntas.getSelectionModel().isEmpty())
			return;

		long cod = perguntas.getSelectionModel().getSelectedItem().getCod();
		Pergunta perguntaSelecionada = new PerguntaController().buscar(cod);
//		List<Resposta> respostasDoBD = new RespostaController().listar();

		// Deletar Pergunta.
		new PerguntaController().deletar(perguntaSelecionada);
		
		// Deletar Respostas Relacionadas à Pergunta.
		List<Resposta> respostasDoBD = perguntaSelecionada.getRespostas();
		for (Resposta r : respostasDoBD) {
				new RespostaController().deletar(r);
		}		
		
		limparControles();
		AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
		mostrarOcultarControles();
		AuxiliarTela.mostrarMensagem(msg, lblMensagem);
		Logging.getControlsLogger().info(
				"Executou Método ->  deletarPergunta()");
	}

	@FXML
	void selecionarPerguntaTabela(MouseEvent event) {
		// Verifica se a tabela está vazia.
		// Caso esteja vazia, não faz nada.
		if (perguntas.getSelectionModel().isEmpty())
			return;

		long cod = perguntas.getSelectionModel().getSelectedItem().getCod();
		Pergunta perguntaSelecionada = new PerguntaController().buscar(cod);
		mostrarPerguntaDaTabela(perguntaSelecionada, cod);
		List<Resposta> respostasDoBD = perguntaSelecionada.getRespostas();
		mostrarRespostasDaTabela(perguntaSelecionada, respostasDoBD);
		mostrarOcultarControles();

		Logging.getControlsLogger().info(
				"Executou Método ->  selecionarPerguntaTabela()");
	}

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert btnDeletar != null : "fx:id=\"btnDeletar\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert btnNova != null : "fx:id=\"btnNova\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert detalhes != null : "fx:id=\"detalhes\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert grupoCabPergResp != null : "fx:id=\"grupoCabPergResp\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert grupoCabecalho != null : "fx:id=\"grupoCabecalho\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert grupoPerguntasRespostas != null : "fx:id=\"grupoPerguntasRespostas\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert hboxBotoes != null : "fx:id=\"hboxBotoes\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblAno != null : "fx:id=\"lblAno\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblBanca != null : "fx:id=\"lblBanca\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblCategoria != null : "fx:id=\"lblCategoria\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblCod != null : "fx:id=\"lblCod\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblObservacoes != null : "fx:id=\"lblObservacoes\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblPergunta != null : "fx:id=\"lblPergunta\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblRespostaA != null : "fx:id=\"lblRespostaA\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblRespostaB != null : "fx:id=\"lblRespostaB\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblRespostaC != null : "fx:id=\"lblRespostaC\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblRespostaD != null : "fx:id=\"lblRespostaD\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert lblRespostaE != null : "fx:id=\"lblRespostaE\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert perguntas != null : "fx:id=\"perguntas\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert rbRespostaA != null : "fx:id=\"rbRespostaA\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert rbRespostaB != null : "fx:id=\"rbRespostaB\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert rbRespostaC != null : "fx:id=\"rbRespostaC\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert rbRespostaD != null : "fx:id=\"rbRespostaD\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert rbRespostaE != null : "fx:id=\"rbRespostaE\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert respostaCorreta != null : "fx:id=\"respostaCorreta\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taObservacoes != null : "fx:id=\"taObservacoes\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taPergunta != null : "fx:id=\"taPergunta\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taRespostaA != null : "fx:id=\"taRespostaA\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taRespostaB != null : "fx:id=\"taRespostaB\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taRespostaC != null : "fx:id=\"taRespostaC\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taRespostaD != null : "fx:id=\"taRespostaD\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert taRespostaE != null : "fx:id=\"taRespostaE\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert tfAno != null : "fx:id=\"tfAno\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert tfBanca != null : "fx:id=\"tfBanca\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert tfCategoria != null : "fx:id=\"tfCategoria\" was not injected: check your FXML file 'cadastro.fxml'.";
		assert tfCod != null : "fx:id=\"tfCod\" was not injected: check your FXML file 'cadastro.fxml'.";

		// Initialize your logic here: all @FXML variables will have been
		// injected
		AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
		mostrarOcultarControles();

	}

	private void limparControles() {
		limparLabelsErro();
		limparCampos();
		tfCategoria.requestFocus();
		Logging.getControlsLogger().info(
				"Executou Método ->  limparControles()");
	}

	private void limparCampos() {
		tfAno.clear();
		tfBanca.clear();
		tfCategoria.clear();
		tfCod.clear();
		taObservacoes.clear();
		taPergunta.clear();
		taRespostaA.clear();
		taRespostaB.clear();
		taRespostaC.clear();
		taRespostaD.clear();
		taRespostaE.clear();
		respostaCorreta.selectToggle(null);
		Logging.getControlsLogger().info("Executou Método ->  limparCampos()");
	}

	private void limparLabelsErro() {
		lblCategoriaErro.setText("");
		lblBancaErro.setText("");
		lblAnoErro.setText("");
		lblPerguntaErro.setText("");
		lblRespostaAErro.setText("");
		lblRespostaBErro.setText("");
		lblRespostaCErro.setText("");
		lblRespostaDErro.setText("");
		lblRespostaEErro.setText("");
		lblRespostaCertaErro.setText("");
		Logging.getControlsLogger().info(
				"Executou Método ->  limparLabelsErro()");
	}

	private void mostrarOcultarControles() {
		AuxiliarTela.mostrarOcultarControles(perguntas, btnDeletar);
		Logging.getControlsLogger().info(
				"Executou Método ->  mostrarOcultarControles()");
	}

	private void alterarDados() {
		// Definindo os novos valores para a pergunta.
		// Diferentemente do salvar, aqui o cod é definido.
		Pergunta pergunta = new Pergunta();
		pergunta.setCod(Long.parseLong(tfCod.getText()));
		pergunta.setAno(Long.parseLong(tfAno.getText()));
		pergunta.setBanca(tfBanca.getText());
		pergunta.setCategoria(tfCategoria.getText());
		pergunta.setTexto(taPergunta.getText());
		pergunta.setObservacao(taObservacoes.getText());
		pergunta.setRespostaCerta(-1); // -1 é um valor arbitrário para mostrar
										// que a resposta ainda não foi
										// definida.
		Resposta respostaA = new Resposta();
		Resposta respostaB = new Resposta();
		Resposta respostaC = new Resposta();
		Resposta respostaD = new Resposta();
		Resposta respostaE = new Resposta();
		
		// Definido os valores para as respostas da pergunta.
		List<Resposta> respostasDoBD = new PerguntaController().buscar(pergunta.getCod()).getRespostas();
		respostaA = respostasDoBD.get(0);
		respostaB = respostasDoBD.get(1);
		respostaC = respostasDoBD.get(2);
		respostaD = respostasDoBD.get(3);
		respostaE = respostasDoBD.get(4);
		respostaA.setTexto(taRespostaA.getText());
		respostaB.setTexto(taRespostaB.getText());
		respostaC.setTexto(taRespostaC.getText());
		respostaD.setTexto(taRespostaD.getText());
		respostaE.setTexto(taRespostaE.getText());
		
		// Adicionando as respostas à pergunta.
		List<Resposta> lresp = new ArrayList<Resposta>();
		lresp.add(respostaA);
		lresp.add(respostaB);
		lresp.add(respostaC);
		lresp.add(respostaD);
		lresp.add(respostaE);
		pergunta.setRespostas(lresp);
		
		// Pegando a resposta correta.
		RadioButton rbSel = (RadioButton) respostaCorreta.getSelectedToggle();

		long codRespostaCerta = -1;
		codRespostaCerta = rbSel.equals(rbRespostaA) ? respostaA.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaB) ? respostaB.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaC) ? respostaC.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaD) ? respostaD.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaE) ? respostaE.getCod()
				: codRespostaCerta;

		pergunta.setRespostaCerta(codRespostaCerta);
		new PerguntaController().atualizar(pergunta);
		Logging.getControlsLogger().info("Executou Método ->  alterarDados()");
	}

	private void salvarDados() {
		// Definindo os valores da pergunta.
		Pergunta pergunta = new Pergunta();
		pergunta.setAno(Long.parseLong(tfAno.getText()));
		pergunta.setBanca(tfBanca.getText());
		pergunta.setCategoria(tfCategoria.getText());
		pergunta.setTexto(taPergunta.getText());
		pergunta.setObservacao(taObservacoes.getText());
		pergunta.setRespostaCerta(-1);

		Resposta respostaA = new Resposta();
		Resposta respostaB = new Resposta();
		Resposta respostaC = new Resposta();
		Resposta respostaD = new Resposta();
		Resposta respostaE = new Resposta();
		
		List<Resposta> lresp = new ArrayList<Resposta>();
		lresp.add(respostaA);
		lresp.add(respostaB);
		lresp.add(respostaC);
		lresp.add(respostaD);
		lresp.add(respostaE);
		pergunta.setRespostas(lresp);

		// Definindo os valores das respostas para a pergunta.
		respostaA.setTexto(taRespostaA.getText());
		respostaB.setTexto(taRespostaB.getText());
		respostaC.setTexto(taRespostaC.getText());
		respostaD.setTexto(taRespostaD.getText());
		respostaE.setTexto(taRespostaE.getText());

		new RespostaController().adicionar(respostaA);
		new RespostaController().adicionar(respostaB);
		new RespostaController().adicionar(respostaC);
		new RespostaController().adicionar(respostaD);
		new RespostaController().adicionar(respostaE);

		// Definindo qual delas é a resposta correta.
		RadioButton rbSel = (RadioButton) respostaCorreta.getSelectedToggle();

		long codRespostaCerta = -1;
		codRespostaCerta = rbSel.equals(rbRespostaA) ? respostaA.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaB) ? respostaB.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaC) ? respostaC.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaD) ? respostaD.getCod()
				: codRespostaCerta;
		codRespostaCerta = rbSel.equals(rbRespostaE) ? respostaE.getCod()
				: codRespostaCerta;

		pergunta.setRespostaCerta(codRespostaCerta);
		new PerguntaController().adicionar(pergunta);
		Logging.getControlsLogger().info("Executou Método ->  salvarDados()");
	}

	private void mostrarPerguntaDaTabela(Pergunta perguntaSelecionada, long cod) {
		limparLabelsErro();
		tfCod.setText("" + cod);
		tfAno.setText("" + perguntaSelecionada.getAno());
		tfBanca.setText(perguntaSelecionada.getBanca());
		tfCategoria.setText(perguntaSelecionada.getCategoria());
		taPergunta.setText(perguntaSelecionada.getTexto());
		taObservacoes.setText(perguntaSelecionada.getObservacao());
	}

	private void mostrarRespostasDaTabela(Pergunta pergSelecionada,
			List<Resposta> respostasDoBD) {
		// Colocando o texto das respostas nos campos.
		int i = 0;
		for (Resposta r : respostasDoBD) {
			if (!r.equals(null)) {
				if (i == 0)
					taRespostaA.setText(r.getTexto());
				if (i == 1)
					taRespostaB.setText(r.getTexto());
				if (i == 2)
					taRespostaC.setText(r.getTexto());
				if (i == 3)
					taRespostaD.setText(r.getTexto());
				if (i == 4)
					taRespostaE.setText(r.getTexto());
			}
			i++;
		}

		// Definindo o RadioButton com a resposta correta.
		i = 0;
		for (Resposta r : respostasDoBD) {
			if (!r.equals(null)
					&& (r.getCod() == pergSelecionada.getRespostaCerta())) {
				if (i == 0)
					rbRespostaA.setSelected(true);
				if (i == 1)
					rbRespostaB.setSelected(true);
				if (i == 2)
					rbRespostaC.setSelected(true);
				if (i == 3)
					rbRespostaD.setSelected(true);
				if (i == 4)
					rbRespostaE.setSelected(true);
			}
			i++;
		}
	}
}
