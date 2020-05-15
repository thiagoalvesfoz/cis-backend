package br.uniamerica.cis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.model.Especialidade;
import br.uniamerica.cis.domain.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService{
	
	@Autowired
	private EspecialidadeRepository repositorio;
	
	public Especialidade save(Especialidade especialidade) {
		return repositorio.save(especialidade);
	}
}
