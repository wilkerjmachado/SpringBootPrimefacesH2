package org.enquete.app.service;

import java.util.List;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.enquete.framework.service.GenericService;

public interface RespostaService extends GenericService<Resposta>{

	List<Resposta> listarPorPergunta(Pergunta pergunta);
}
