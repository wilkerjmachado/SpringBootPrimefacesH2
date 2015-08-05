package org.enquete.app.service.impl;

import org.enquete.app.dominio.Opcao;
import org.enquete.app.service.OpcaoService;
import org.enquete.app.service.repository.OpcaoRepository;
import org.enquete.framework.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcaoServiceImpl extends GenericServiceImpl<Opcao, OpcaoRepository>implements OpcaoService {

	@Autowired
	public OpcaoServiceImpl(OpcaoRepository repository) {
		super(repository);
	}

}
