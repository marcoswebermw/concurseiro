package br.mw.conc.model;

import java.util.ArrayList;
import java.util.List;

public class PerguntaRespostas {
	private Pergunta pergunta;
	private ArrayList<Resposta> respostas;
	
	public PerguntaRespostas(Pergunta pergunta, ArrayList<Resposta> respostas){
		this.pergunta = pergunta;
		this.respostas = respostas;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}
	
	public String mostraPergunta(){
		return pergunta.getTexto();
	}
	
	public String mostraRespostaCerta(){
		return pegaRespostaCerta().getTexto();
	}
	
	public String mostraCategoria(){
		return pergunta.getCategoria();
	}
	
	public Resposta pegaRespostaCerta(){
		Resposta respostaCerta = new Resposta();
		for (Resposta r : respostas) {
			if (r.getCerta().toUpperCase().equals("S")) {
				respostaCerta = r;
			}
		}
		return respostaCerta;
	}
}
