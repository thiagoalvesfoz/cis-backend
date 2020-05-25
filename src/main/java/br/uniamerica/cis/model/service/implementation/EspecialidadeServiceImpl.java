package br.uniamerica.cis.model.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.EspecialidadeRepository;
import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.EspecialidadeService;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repository;
	
	@Override
	public Especialidade save(Especialidade especialidade) {
		return repository.save(especialidade);
	}

	@Override
	public List<Especialidade> findAll() {		
		return repository.findAll();
	}

	@Override
	public Especialidade findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException(id));
	}
}
