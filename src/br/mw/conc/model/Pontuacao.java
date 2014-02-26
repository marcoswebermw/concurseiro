package br.mw.conc.model;

public class Pontuacao {
	private String nome;

	private int acertou = 0;

	private int errou = 0;

	private int indicePergunta = 0;

	public Pontuacao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAcertou() {
		return acertou;
	}

	public void acertou() {
		this.acertou++;
	}

	public int getErrou() {
		return errou;
	}

	public void errou() {
		this.errou++;
	}

	public int getIndicePergunta() {
		return indicePergunta;
	}

	public void incrementaIndicePergunta() {
		this.indicePergunta++;
	}

	public int getNumQuestoes() {
		return this.acertou + this.errou;
	}
}
