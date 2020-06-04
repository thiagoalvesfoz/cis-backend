package br.uniamerica.cis.model.service.implementation;

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
	private final PessoaService usuarioService;
	private final EspecialidadeService espService;
	
	@Override
	public Profissional save(Profissional profissional) {
		
		Long idEspecialidade = profissional.getEspecialidade().getId();
		
		usuarioService.validateUserEmail(profissional.getEmail());
		
		Optional<Profissional> verifyCrm = repository.findByCrm(profissional.getCrm());
		Optional<Especialidade> verifyEspecialidade = espService.getEspecialidadeById(idEspecialidade);
		
		if(verifyCrm.isPresent())
			throw new BusinessRuleException("Não é possível cadastrar. CRM em uso");
		
		if(verifyEspecialidade.isEmpty()) {
			throw new ResourceNotFoundException(idEspecialidade + " de Especialidade");
		}

		return repository.save(profissional);
	}

	@Override
	public List<Profissional> findAll() {
		return repository.findAll();
	}

	@Override
	public Profissional findById(Long id) {		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
}
