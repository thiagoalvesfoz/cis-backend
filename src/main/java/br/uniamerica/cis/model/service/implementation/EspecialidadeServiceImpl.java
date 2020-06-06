package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.EspecialidadeRepository;
import br.uniamerica.cis.infrastructure.repository.ServicoRepository;
import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.entity.Servico;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.EspecialidadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspecialidadeServiceImpl implements EspecialidadeService {
	
	private final EspecialidadeRepository repository;
	private final ServicoRepository serviceRepository;
	
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
		return repository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Especialidade não encontrada"));
	}
	
	@Override
	public Optional<Especialidade> getEspecialidadeById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Servico> findAllServices(Long id) {
		Especialidade especialidade = this.findById(id);
		return serviceRepository.findByEspecialidade(especialidade);
	}

	@Override
	public void atualizar(Long id, String nome) {
		Especialidade especialidade = this.findById(id);
		especialidade.setNome(nome);
		repository.save(especialidade);
	}
}
