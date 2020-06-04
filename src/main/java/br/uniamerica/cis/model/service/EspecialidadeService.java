package br.uniamerica.cis.model.service;

import java.util.List;
import java.util.Optional;

import br.uniamerica.cis.model.entity.Especialidade;

public interface EspecialidadeService extends ServicoService {
	Especialidade save(Especialidade especialidade);
	List<Especialidade> findAll();
	Especialidade findById(Long id);
	Optional<Especialidade> getEspecialidadeById(Long id);
}
