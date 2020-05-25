package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Especialidade;

public interface EspecialidadeService {
	Especialidade save(Especialidade especialidade);
	List<Especialidade> findAll();
	Especialidade findById(Long id);
}
