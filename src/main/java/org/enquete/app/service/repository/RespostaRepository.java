package org.enquete.app.service.repository;

import java.util.List;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Long> {

	List<Resposta> findByPergunta(Pergunta pergunta);
}
