package br.mw.conc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

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

	@Lob
	@Column(length = 10000, name = "texto")
	private String texto;

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

}