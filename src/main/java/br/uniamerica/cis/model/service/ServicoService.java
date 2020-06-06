package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Servico;

public interface ServicoService {
	List<Servico> findAllServices();
	Servico save(Servico entity);
	Servico findServiceById(Long id);
	Servico updated(Long id, Servico updated);
	void delete(Long id);
}
