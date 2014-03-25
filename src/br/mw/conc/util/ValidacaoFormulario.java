package br.mw.conc.util;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;

public class ValidacaoFormulario {

	// Verifica se o campo não está com texto vazio ou é um objeto nulo.
	public static boolean campoPreenchido(TextInputControl t) {
		boolean r = false;
		if (t.getText() != null && !t.getText().isEmpty()) {
			r = true;
		}
		return r;
	}

	// Se o campo estiver vazio retorna false e uma mensagem indicando.
	public static boolean campoPreenchido(TextInputControl t, Label lb,
			String txtValidacao) {
		boolean r = true;
		String c = null;
		if (!campoPreenchido(t)) {
			r = false;
			c = txtValidacao;
		}

		lb.setText(c);
		return r;
	}

	// Se o campo estiver vazio retorna false e uma mensagem indicando.
	public static boolean campoAnoPreenchidoCorretamente(TextInputControl t,
			Label lb, String txtValidacao) {
		boolean r = true;
		String c = null;
		if (!campoPreenchido(t)) {
			r = false;
			c = txtValidacao;
		} else {
			Pattern p = Pattern.compile("[^0]\\d{3,3}");
			Matcher m = p.matcher(t.getText());
			if (!m.matches()) {
				c = "Ano com 4 dígitos!";
				r = false;
			}

			try {
				Calendar ano = Calendar.getInstance();
				ano.set(Calendar.YEAR, Integer.parseInt(t.getText()));
			} catch (Exception e) {
				c = "Ano inválido. Ex:2015";
				r = false;
			}

		}

		lb.setText(c);
		return r;
	}

	// Verifica se tem algum RadioButton Selecionado através do seu ToggleGroup.
	public static boolean respostaMarcada(ToggleGroup t, Label lb,
			String txtValidacao) {
		boolean r = true;
		String c = null;
		if (t.getSelectedToggle() == null) {
			r = false;
			c = txtValidacao;
		}
		lb.setText(c);
		return r;
	}
}
