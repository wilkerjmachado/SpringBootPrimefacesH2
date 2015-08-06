package org.enquete.app.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.enquete.framework.dominio.Entidade;

@Entity
public class Opcao extends Entidade {

	private String conteudo;

	private Integer quantidadeVoto;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Pergunta pergunta;

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Integer getQuantidadeVoto() {
		if(quantidadeVoto == null){
			quantidadeVoto = 0;
		}
		return quantidadeVoto;
	}

	public void setQuantidadeVoto(Integer quantidadeVoto) {
		this.quantidadeVoto = quantidadeVoto;
	}

}
