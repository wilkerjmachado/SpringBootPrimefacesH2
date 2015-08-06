package org.enquete.app.controller;

import java.util.ArrayList;

import org.enquete.app.dominio.Opcao;
import org.enquete.app.dominio.Pergunta;
import org.enquete.app.formulario.PerguntaFormulario;
import org.enquete.app.service.PerguntaService;
import org.enquete.framework.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnqueteController extends GenericController<Pergunta, PerguntaFormulario, PerguntaService> {

	@Autowired
	public EnqueteController(PerguntaService perguntaService, PerguntaFormulario formulario) {

		super(formulario, perguntaService);

	}

	@Override
	public void salvar() {

		if (validarCaptha()) {

			super.salvar();
		}
	}

	@Override
	public void novaEntidade() {

		super.novaEntidade();

		this.getFormulario().getEntidade().setOpcoes(new ArrayList<Opcao>());
	}

	@Override
	protected void iniciarCampos() {

		this.getFormulario().setOpcao(new Opcao());

		super.iniciarCampos();

		this.getFormulario().getEntidade().setOpcoes(new ArrayList<Opcao>());
	}

	public void addOpcao() {

		this.getFormulario().getEntidade().getOpcoes().add(this.getFormulario().getOpcao());

		this.getFormulario().setOpcao(new Opcao());
	}

	public void removerOpcao(Opcao opcao, Integer index) {

		this.getFormulario().getEntidade().getOpcoes().remove(opcao);

	}

	public void visualizarRespostas(Pergunta pergunta) {

		this.getFormulario().setMostrarRespostas(Boolean.TRUE);

		this.getFormulario().setEntidade(this.getService().findOne(pergunta.getId()));
	}

	public void mostrarEnquetes() {

		this.getFormulario().setMostrarRespostas(Boolean.FALSE);
	}

	public String pageEdit() {

		this.iniciarCampos();

		return "adm/index";
	}

	public String pageList() {

		this.getFormulario().setLista(this.getService().getAll());

		return "/index";
	}
}
