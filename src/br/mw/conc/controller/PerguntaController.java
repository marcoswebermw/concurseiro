package br.mw.conc.controller;

import java.util.List;

import br.mw.conc.model.Pergunta;
import br.mw.conc.model.persistencia.PerguntaDAO;

public class PerguntaController {

	public void adicionar(Pergunta pergunta) {
		// validarPergunta(pergunta);
		new PerguntaDAO().add(pergunta);
	}

	public void atualizar(Pergunta pergunta) {
		new PerguntaDAO().update(pergunta);
	}

	public void deletar(Pergunta pergunta) {
		new PerguntaDAO().del(pergunta);
	}

	public Pergunta buscar(long codPergunta) {
		return new PerguntaDAO().busca(codPergunta);
	}

	public List<Pergunta> listar() {
		return new PerguntaDAO().lista();
	}

	public Pergunta RetornaUltimoRegistro() {
		return new PerguntaDAO().ultimoRegistro();
	}
}
