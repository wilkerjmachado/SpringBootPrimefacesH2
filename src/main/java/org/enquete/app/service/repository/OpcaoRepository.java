package org.enquete.app.service.repository;

import org.enquete.app.dominio.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Long>{

}
