package org.enquete.app.service.repository;

import java.util.List;

import org.enquete.app.dominio.Pergunta;
import org.enquete.app.dominio.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	List<Resposta> findByPergunta(Pergunta pergunta);
}
