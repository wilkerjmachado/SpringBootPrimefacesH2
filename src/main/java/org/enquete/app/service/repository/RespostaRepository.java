package org.enquete.app.service.repository;

import org.enquete.app.dominio.Resposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta, Long> {

}
