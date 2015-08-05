package org.enquete.app.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.enquete.framework.dominio.Entidade;

@Entity
public class Pergunta extends Entidade {

	private String texto;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private EnumTipoEnquete tipoEnquete;

	// TODO Coloquei EAGER mas nao e correto teria que ser LAZY e criar um
	// filtro do spring que inicializa a propriedade sobre demanda
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Resposta> listaRespostas;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Opcao> opcoes;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Opcao> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(List<Opcao> opcoes) {
		this.opcoes = opcoes;
	}

	public EnumTipoEnquete getTipoEnquete() {
		return tipoEnquete;
	}

	public void setTipoEnquete(EnumTipoEnquete tipoEnquete) {
		this.tipoEnquete = tipoEnquete;
	}

}
