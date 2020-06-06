package br.uniamerica.cis.model.service;

import java.util.List;
import java.util.Optional;

import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.entity.Servico;

public interface EspecialidadeService {
	Especialidade save(Especialidade especialidade);
	List<Especialidade> findAll();
	Especialidade findById(Long id);
	Optional<Especialidade> getEspecialidadeById(Long id);
	void atualizar(Long id, String nome);
	List<Servico> findAllServices(Long id);
}
