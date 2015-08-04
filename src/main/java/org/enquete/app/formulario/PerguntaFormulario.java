package org.enquete.app.formulario;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.framework.formulario.GenericForm;
import org.springframework.stereotype.Component;

@Component
public class PerguntaFormulario extends GenericForm<Pergunta> {

	private Resposta resposta;

	private Boolean mostrarRespostas = Boolean.FALSE;

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public Boolean getMostrarRespostas() {
		return mostrarRespostas;
	}

	public void setMostrarRespostas(Boolean mostrarRespostas) {
		this.mostrarRespostas = mostrarRespostas;
	}

}
