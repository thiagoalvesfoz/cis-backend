package br.uniamerica.cis.model.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.ProfissionalRepository;
import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.entity.Profissional;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.EspecialidadeService;
import br.uniamerica.cis.model.service.PessoaService;
import br.uniamerica.cis.model.service.ProfissionalService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissionalServiceImpl implements ProfissionalService {	

	private final ProfissionalRepository repository;
	private final PessoaService pessoaService;
	private final EspecialidadeService espService;
	
	@Override
	public Profissional save(Profissional profissional) {
		
		Long idEspecialidade = profissional.getEspecialidade().getId();		
		pessoaService.validateUserEmail(profissional.getEmail());
		
		Optional<Profissional> verifyCrm = repository.findByCrm(profissional.getCrm());
		Optional<Especialidade> verifyEspecialidade = espService.getEspecialidadeById(idEspecialidade);
		
		if(verifyCrm.isPresent())
			throw new BusinessRuleException("Não é possível cadastrar. CRM em uso");
		
		if(verifyEspecialidade.isEmpty())
			throw new ResourceNotFoundException("Especialidade não encontrada");

		
		profissional.setCreatedAt(LocalDateTime.now());
		return repository.save(profissional);
	}

	@Override
	public List<Profissional> findAll() {
		return repository.findAll();
	}

	@Override
	public Profissional findById(Long id) {		
		return repository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Profissional não encontrado"));
	}

	@Override
	public Profissional upgrade(Long id, Profissional upgraded) {
		
		var profissional = this.findById(id);
		var especialidade = espService.findById(upgraded.getEspecialidade().getId());
		
		profissional.setNome(upgraded.getNome());
		profissional.setSobrenome(upgraded.getSobrenome());
		profissional.setDataNascimento(upgraded.getDataNascimento());
		profissional.setTelefone(upgraded.getTelefone());
		profissional.setCrm(upgraded.getCrm());
		profissional.getEspecialidade().setId(especialidade.getId());
		
		if(!upgraded.getImgUrl().equals(profissional.getImgUrl()))
			profissional.setImgUrl(upgraded.getImgUrl());
		
		return repository.save(profissional);
	}
	
}
