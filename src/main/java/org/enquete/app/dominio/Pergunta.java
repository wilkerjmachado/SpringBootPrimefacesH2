package org.enquete.app.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.enquete.framework.dominio.Entidade;

@Entity
public class Pergunta extends Entidade {

	private String texto;

	// TODO Coloquei EAGER mas nao e correto teria que ser LAZY e criar um filtro do spring que inicializa a propriedade sobre demanda
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pergunta", cascade = CascadeType.ALL)
	private List<Resposta> listaRespostas;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Resposta> getListaRespostas() {
		return listaRespostas;
	}

	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}

}
