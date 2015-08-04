package org.enquete.app.service.impl;

import java.util.List;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.app.service.RespostaService;
import org.enquete.app.service.repository.RespostaRepository;
import org.enquete.framework.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaServiceImpl extends GenericServiceImpl<Resposta, RespostaRepository>implements RespostaService {

	@Autowired
	public RespostaServiceImpl(RespostaRepository respostaRepository) {
		super(respostaRepository);
	}

	@Override
	public List<Resposta> listarPorPergunta(Pergunta pergunta) {
		
		return this.repository.findByPergunta(pergunta);
	}

}
