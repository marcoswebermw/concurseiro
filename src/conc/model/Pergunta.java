package conc.model;

/**
 * Classe que representa a entidade Pergunta.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	@Column(name = "ano")
	private long ano;

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

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
		this.ano = ano;
	}

}
