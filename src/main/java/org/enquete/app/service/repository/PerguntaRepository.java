package org.enquete.app.service.repository;

import org.enquete.app.dominio.Pergunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends CrudRepository<Pergunta, Long>{

}
