package org.enquete.app.dominio;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.enquete.framework.dominio.Entidade;

@Entity
public class Resposta extends Entidade {

	private String texto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Pergunta pergunta;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
