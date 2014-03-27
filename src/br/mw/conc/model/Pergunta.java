package br.mw.conc.model;

/**
 * Classe que representa a entidade Pergunta.
 */

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author marcos
 * 
 */
@Entity
public class Pergunta {

	@Id
	@GeneratedValue
	@Column(name = "cod")
	private long cod;

	@Column(name = "texto")
	private String texto;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "banca")
	private String banca;

	@Column(name = "prova")
	private String prova;

	@Column(name = "ano")
	private long ano;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "fk_resposta_cod")
	private long respostaCerta;

	@OneToMany
	private List<Resposta> respostas;

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

	public String getProva() {
		return prova;
	}

	public void setProva(String prova) {
		this.prova = prova;
	}	
	
	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public long getRespostaCerta() {
		return respostaCerta;
	}

	public void setRespostaCerta(long respostaCerta) {
		this.respostaCerta = respostaCerta;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

}
