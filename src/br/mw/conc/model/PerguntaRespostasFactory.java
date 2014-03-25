package br.mw.conc.model;

import java.util.ArrayList;
import java.util.List;

public class PerguntaRespostasFactory {
	private List<Pergunta> perguntas;
	private List<Resposta> respostas;
	private List<PerguntaRespostas> listaPerguntasRespostas = new ArrayList<PerguntaRespostas>();

	public PerguntaRespostasFactory(List<Pergunta> perguntas,
			List<Resposta> respostas) {
		this.perguntas = perguntas;
		this.respostas = respostas;
	}

	public List<PerguntaRespostas> getPerguntaRespostas() {
		PerguntaRespostas perguntaRespostas;
		ArrayList<Resposta> listaRespostas;

		for (Pergunta pergunta : perguntas) {
			listaRespostas = (ArrayList<Resposta>) pergunta.getRespostas();
			perguntaRespostas = new PerguntaRespostas(pergunta, listaRespostas);
			listaPerguntasRespostas.add(perguntaRespostas);
		}

		return listaPerguntasRespostas;
	}
}
