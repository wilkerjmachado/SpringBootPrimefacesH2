package org.enquete.app.service.impl;

import org.enquete.app.dominio.Opcao;
import org.enquete.app.dominio.Pergunta;
import org.enquete.app.service.PerguntaService;
import org.enquete.app.service.repository.PerguntaRepository;
import org.enquete.framework.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerguntaServiceImpl extends GenericServiceImpl<Pergunta, PerguntaRepository>implements PerguntaService {

	@Autowired
	public PerguntaServiceImpl(PerguntaRepository perguntaRepository) {

		super(perguntaRepository);
	}

	@Override
	public Pergunta saveOrUpdate(Pergunta entidade) {

		for(Opcao opcao : entidade.getOpcoes()){
			
			opcao.setPergunta(entidade);
			
		}
		
		return super.saveOrUpdate(entidade);
	}
}
