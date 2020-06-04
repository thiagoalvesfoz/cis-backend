package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Servico;

public interface ServicoService {
	List<Servico> findAllServices(Long id);
}
