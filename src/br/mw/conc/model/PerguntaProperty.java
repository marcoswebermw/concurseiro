package br.mw.conc.model;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class PerguntaProperty {
	private SimpleLongProperty cod;
	private SimpleStringProperty texto;
	private SimpleStringProperty categoria;
	private SimpleStringProperty banca;
	private SimpleStringProperty prova;
	private SimpleLongProperty ano;
	private SimpleStringProperty observacao;
	private SimpleLongProperty respostaCerta;

	public PerguntaProperty(Long cod, String texto, String categoria, String banca, String prova, String observacao, long ano, long respostaCerta) {
		this.cod = new SimpleLongProperty(cod);
		this.texto = new SimpleStringProperty(texto);
		this.categoria = new SimpleStringProperty(categoria);
		this.banca = new SimpleStringProperty(banca);
		this.prova = new SimpleStringProperty(prova);
		this.ano = new SimpleLongProperty(ano);
		this.observacao = new SimpleStringProperty(observacao);
		this.respostaCerta = new SimpleLongProperty(respostaCerta);
	}

	public long getCod() {
		return cod.get();
	}

	public String getTexto() {
		return texto.get();
	}

	public String getCategoria() {
		return categoria.get();
	}

	public String getBanca() {
		return banca.get();
	}

	public String getProva() {
		return prova.get();
	}	
	
	public String getObservacao() {
		return observacao.get();
	}

	public long getAno() {
		return ano.get();
	}

	public long getPerguntaCerta() {
		return respostaCerta.get();
	}
	
	
}
