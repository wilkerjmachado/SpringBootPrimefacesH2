package org.enquete.app.formulario;

import java.util.List;

import org.enquete.app.dominio.Pergunta;
import org.springframework.stereotype.Component;

@Component
public class PerguntaFormulario {

	private List<Pergunta> lista;

	private Pergunta entidade;

	public List<Pergunta> getLista() {
		return lista;
	}

	public void setLista(List<Pergunta> lista) {
		this.lista = lista;
	}

	public Pergunta getEntidade() {
		if (entidade == null) {
			entidade = new Pergunta();
		}
		return entidade;
	}

	public void setEntidade(Pergunta entidade) {
		this.entidade = entidade;
	}

}
