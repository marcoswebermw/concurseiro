package br.mw.conc.util;

import java.util.List;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import br.mw.conc.controller.PerguntaController;
import br.mw.conc.model.Pergunta;
import br.mw.conc.model.PerguntaProperty;

public class AuxiliarTela {

	// Mostra ou oculta controles da tela se a tabela estivar vazia ou não.
	public static void mostrarOcultarControles(TableView<PerguntaProperty> tv,
			Button btn) {
		if (tv.getSelectionModel().isEmpty()
				|| tv.getSelectionModel().getSelectedIndex() < 0) {
			btn.setDisable(true);
			tv.getSelectionModel().clearSelection();
		} else {
			btn.setDisable(false);
		}
	}

	// Mostra uma mensagem em um Label com efeito fade.
	public static void mostrarMensagem(String msg, Label lblMensagem) {
		lblMensagem.setText(msg);
		FadeTransition fadeTransition = new FadeTransition(
				Duration.millis(4000), lblMensagem);
		fadeTransition.setFromValue(0.0);
		fadeTransition.setToValue(1.0);
		fadeTransition.play();

		fadeTransition = new FadeTransition(Duration.millis(4000), lblMensagem);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		fadeTransition.play();
	}

	// Define os valores das colunas de uma tabela.
	public static void montarTabela(TableView<PerguntaProperty> p) {
		TableColumn columnCod = p.getColumns().get(0);
		TableColumn columnCategoria = p.getColumns().get(1);
		TableColumn columnBanca = p.getColumns().get(2);
		TableColumn columnProva = p.getColumns().get(3);
		TableColumn columnAno = p.getColumns().get(4);
		TableColumn columnPergunta = p.getColumns().get(5);

		columnCod
				.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, Long>(
						"cod"));
		columnCategoria
				.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, String>(
						"categoria"));
		columnBanca
				.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, String>(
						"banca"));
		columnProva
		.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, String>(
				"prova"));		
		columnAno
				.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, Long>(
						"ano"));
		columnPergunta
				.setCellValueFactory(new PropertyValueFactory<PerguntaProperty, String>(
						"texto"));
	}

	// Coloca os valores na tabela.
	public static void carregarTabelaPerguntas(TextField tf,
			TableView<PerguntaProperty> perguntas) {
		List<Pergunta> perguntasDoBD = new PerguntaController().listar();
		ObservableList<PerguntaProperty> listaObservavelPerguntas = FXCollections
				.observableArrayList();

		for (Pergunta p : perguntasDoBD) {
			PerguntaProperty perguntaProperty = new PerguntaProperty(
					p.getCod(), p.getTexto(), p.getCategoria(), p.getBanca(),
					p.getProva(), p.getObservacao(), p.getAno(),
					p.getRespostaCerta());
			listaObservavelPerguntas.add(perguntaProperty);
		}

		tf.setDisable(true);
		AuxiliarTela.montarTabela(perguntas);
		perguntas.setItems(listaObservavelPerguntas);
	}
}
