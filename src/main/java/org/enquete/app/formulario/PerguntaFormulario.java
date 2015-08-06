package org.enquete.app.formulario;

import org.enquete.app.dominio.EnumTipoEnquete;
import org.enquete.app.dominio.Opcao;
import org.enquete.app.dominio.Pergunta;
import org.enquete.framework.formulario.GenericForm;
import org.springframework.stereotype.Component;

@Component
public class PerguntaFormulario extends GenericForm<Pergunta> {

	private Opcao opcao;

	private EnumTipoEnquete[] tiposEnquete = EnumTipoEnquete.values();

	private Boolean mostrarRespostas = Boolean.FALSE;

	public Opcao getOpcao() {
		return opcao;
	}

	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}

	public EnumTipoEnquete[] getTiposEnquete() {
		return tiposEnquete;
	}

	public void setTiposEnquete(EnumTipoEnquete[] tiposEnquete) {
		this.tiposEnquete = tiposEnquete;
	}

	public Boolean getMostrarRespostas() {
		return mostrarRespostas;
	}

	public void setMostrarRespostas(Boolean mostrarRespostas) {
		this.mostrarRespostas = mostrarRespostas;
	}

}
