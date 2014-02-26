package br.mw.conc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author marcos
 * 
 */
@Entity
public class Resposta {
	@Id
	@GeneratedValue
	@Column(name = "cod")
	private long cod;

	@Column(name = "texto")
	private String texto;

	@Column(name = "certa")
	// Indica se esta é uma resposta correta ou não.
	private String certa;

	@Column(name = "fk_pergunta_cod")
	private long codigoPergunta;

	// GETTERS E SETTERS

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

	public String getCerta() {
		return certa;
	}

	public void setCerta(String certa) {
		this.certa = certa;
	}

	public long getCodigoPergunta() {
		return codigoPergunta;
	}

	public void setCodigoPergunta(long codigoPergunta) {
		this.codigoPergunta = codigoPergunta;
	}

}