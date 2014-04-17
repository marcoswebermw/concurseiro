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

//import com.sun.javafx.scene.control.Logging;

public class GerenciarPerguntasController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDeletar;

    @FXML
    private Button btnNova;

    @FXML
    private Button btnSalver;

    @FXML
    private Label lblAnoErro;

    @FXML
    private Label lblBancaErro;

    @FXML
    private Label lblCategoriaErro;

    @FXML
    private Label lblMensagem;

    @FXML
    private Label lblPerguntaErro;

    @FXML
    private Label lblProvaErro;

    @FXML
    private Label lblRespostaAErro;

    @FXML
    private Label lblRespostaBErro;

    @FXML
    private Label lblRespostaCertaErro;

    @FXML
    private TableView<PerguntaProperty> perguntas;

    @FXML
    private RadioButton rbRespostaA;

    @FXML
    private RadioButton rbRespostaB;

    @FXML
    private RadioButton rbRespostaC;

    @FXML
    private RadioButton rbRespostaD;

    @FXML
    private RadioButton rbRespostaE;

    @FXML
    private ToggleGroup respostaCorreta;

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
    private TextField tfAno;

    @FXML
    private TextField tfBanca;

    @FXML
    private TextField tfCategoria;

    @FXML
    private TextField tfCod;

    @FXML
    private TextField tfProva;
	
	
	
	// Handler for Button[fx:id="btnNova"] onAction
	@FXML
	void novaPergunta(ActionEvent event) {
		limparControles();
		AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
		mostrarOcultarControles();
//		Logging.getControlsLogger().info("Executou Metodo ->  novaPergunta()");
	}

	// Handler for Button[fx:id="btnSalvar"] onAction
	@FXML
	void salvarPergunta(ActionEvent event) {
		boolean categoriaErro = ValidacaoFormulario.campoPreenchido(
				tfCategoria, lblCategoriaErro, "*Informe a categoria!");
		boolean bancaErro = ValidacaoFormulario.campoPreenchido(tfBanca,
				lblBancaErro, "*Informe a banca!");
		boolean anoErro = ValidacaoFormulario.campoAnoPreenchidoCorretamente(
				tfAno, lblAnoErro, "*Informe o ano!");
		boolean perguntaErro = ValidacaoFormulario.campoPreenchido(taPergunta,
				lblPerguntaErro, "*Informe a pergunta!");
		boolean provaErro = ValidacaoFormulario.campoPreenchido(taPergunta,
				lblProvaErro, "*Informe a prova!");
		// Existem questões com apenas opção de verdadeiro e falso.
		 boolean respostaAErro = ValidacaoFormulario.campoPreenchido(
		 taRespostaA, lblRespostaAErro, "*Informe obrigatoriamente a resposta A!");
		 boolean respostaBErro = ValidacaoFormulario.campoPreenchido(
		 taRespostaB, lblRespostaBErro, "*Informe obrigatoriamente a resposta B!");
		// boolean respostaCErro = ValidacaoFormulario.campoPreenchido(
		// taRespostaC, lblRespostaCErro, "Preencha a resposta C!");
		// boolean respostaDErro = ValidacaoFormulario.campoPreenchido(
		// taRespostaD, lblRespostaDErro, "Preencha a resposta D!");
		// boolean respostaEErro = ValidacaoFormulario.campoPreenchido(
		// taRespostaE, lblRespostaEErro, "Preencha a resposta E!");
		boolean respostaCertaErro = ValidacaoFormulario.respostaMarcada(
				respostaCorreta, lblRespostaCertaErro, "*Marque a resposta correta!");

		// Validando Campos, Salvando ou Alterando Pergunta e Suas Respostas.
		String msg = null;
		// if (categoriaErro && bancaErro && anoErro && perguntaErro &&
		// respostaAErro && respostaBErro && respostaCErro && respostaDErro &&
		// respostaEErro && respostaCertaErro) {
		if (categoriaErro && bancaErro && anoErro && perguntaErro
				&& respostaAErro && respostaBErro && respostaCertaErro && provaErro) {
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
//		Logging.getControlsLogger()
//				.info("Executou Método ->  salvarPergunta()");
	}

	// Handler for Button[fx:id="btnDeletar"] onAction
	@FXML
	void deletarPergunta(ActionEvent event) {
		String msg = "Pergunta excluída corretamente!";
		if (perguntas.getSelectionModel().isEmpty())
			return;

		long cod = perguntas.getSelectionModel().getSelectedItem().getCod();
		Pergunta perguntaSelecionada = new PerguntaController().buscar(cod);
		// List<Resposta> respostasDoBD = new RespostaController().listar();

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
//		Logging.getControlsLogger().info(
//				"Executou Método ->  deletarPergunta()");
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

//		Logging.getControlsLogger().info(
//				"Executou Método ->  selecionarPerguntaTabela()");
	}

	@FXML
	// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
        assert btnDeletar != null : "fx:id=\"btnDeletar\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert btnNova != null : "fx:id=\"btnNova\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert btnSalver != null : "fx:id=\"btnSalver\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblAnoErro != null : "fx:id=\"lblAnoErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblBancaErro != null : "fx:id=\"lblBancaErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblCategoriaErro != null : "fx:id=\"lblCategoriaErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblMensagem != null : "fx:id=\"lblMensagem\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblPerguntaErro != null : "fx:id=\"lblPerguntaErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblProvaErro != null : "fx:id=\"lblProvaErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblRespostaAErro != null : "fx:id=\"lblRespostaAErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblRespostaBErro != null : "fx:id=\"lblRespostaBErro\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert lblRespostaCertaErro != null : "fx:id=\"lblRespostaCertaErro\" was not injected: check your FXML file 'cadastro.fxml'.";
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
        assert tfProva != null : "fx:id=\"tfProva\" was not injected: check your FXML file 'cadastro.fxml'.";



		// Initialize your logic here: all @FXML variables will have been
		// injected
		AuxiliarTela.carregarTabelaPerguntas(tfCod, perguntas);
		mostrarOcultarControles();

	}

	private void limparControles() {
		limparLabelsErro();
		limparCampos();
		tfCategoria.requestFocus();
//		Logging.getControlsLogger().info(
//				"Executou Método ->  limparControles()");
	}

	private void limparCampos() {
		tfCod.clear();
		tfCategoria.clear();
		tfBanca.clear();
		tfProva.clear();
		tfAno.clear();
		taObservacoes.clear();
		taPergunta.clear();
		taRespostaA.clear();
		taRespostaB.clear();
		taRespostaC.clear();
		taRespostaD.clear();
		taRespostaE.clear();
		respostaCorreta.selectToggle(null);
//		Logging.getControlsLogger().info("Executou Método ->  limparCampos()");
	}

	private void limparLabelsErro() {
		lblCategoriaErro.setText("");
		lblBancaErro.setText("");
		lblProvaErro.setText("");
		lblAnoErro.setText("");
		lblPerguntaErro.setText("");
		lblRespostaAErro.setText("");
		lblRespostaBErro.setText("");
		lblRespostaCertaErro.setText("");
//		Logging.getControlsLogger().info(
//				"Executou Método ->  limparLabelsErro()");
	}

	private void mostrarOcultarControles() {
		AuxiliarTela.mostrarOcultarControles(perguntas, btnDeletar);
//		Logging.getControlsLogger().info(
//				"Executou Método ->  mostrarOcultarControles()");
	}

	private void alterarDados() {
		// Definindo os novos valores para a pergunta.
		// Diferentemente do salvar, aqui o cod é definido.
		Pergunta pergunta = new Pergunta();
		pergunta.setCod(Long.parseLong(tfCod.getText()));
		pergunta.setCategoria(tfCategoria.getText());
		pergunta.setBanca(tfBanca.getText());
		pergunta.setProva(tfProva.getText());
		pergunta.setAno(Long.parseLong(tfAno.getText()));
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
		List<Resposta> respostasDoBD = new PerguntaController().buscar(
				pergunta.getCod()).getRespostas();
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
//		Logging.getControlsLogger().info("Executou Método ->  alterarDados()");
	}

	private void salvarDados() {
		// Definindo os valores da pergunta.
		Pergunta pergunta = new Pergunta();
		pergunta.setCategoria(tfCategoria.getText());
		pergunta.setBanca(tfBanca.getText());
		pergunta.setProva(tfProva.getText());
		pergunta.setAno(Long.parseLong(tfAno.getText()));
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
//		Logging.getControlsLogger().info("Executou Método ->  salvarDados()");
	}

	private void mostrarPerguntaDaTabela(Pergunta perguntaSelecionada, long cod) {
		limparLabelsErro();
		tfCod.setText("" + cod);
		tfCategoria.setText(perguntaSelecionada.getCategoria());
		tfBanca.setText(perguntaSelecionada.getBanca());
		tfProva.setText(perguntaSelecionada.getProva());
		tfAno.setText("" + perguntaSelecionada.getAno());
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
