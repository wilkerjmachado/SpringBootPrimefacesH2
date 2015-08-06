package org.enquete.app.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.enquete.app.dominio.Opcao;
import org.enquete.app.service.OpcaoService;
import org.enquete.app.service.repository.OpcaoRepository;
import org.enquete.framework.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OpcaoServiceImpl extends GenericServiceImpl<Opcao, OpcaoRepository>implements OpcaoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public OpcaoServiceImpl(OpcaoRepository repository) {
		super(repository);
	}

	@Override
	@Transactional
	public Opcao saveOrUpdate(Opcao entidade) {

		if (entidade.getId() != null) {
			
			entidade = this.findOne(entidade.getId());

			entidade.setQuantidadeVoto(entidade.getQuantidadeVoto() + 1);

			return entityManager.merge(entidade);
		}

		return null;
	}
}
