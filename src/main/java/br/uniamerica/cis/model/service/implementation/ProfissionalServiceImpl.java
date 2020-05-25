package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.ProfissionalRepository;
import br.uniamerica.cis.model.entity.Profissional;
import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.ProfissionalService;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {
	
	@Autowired
	private ProfissionalRepository repository;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Override
	public Profissional save(Profissional profissional) {		
		
		usuarioService.validateUserEmail(profissional.getEmail());		
		Optional<Profissional> verifyCrm = repository.findByCrm(profissional.getCrm());
		
		if(verifyCrm.isPresent())
			throw new BusinessRuleException("Não é possível cadastrar. CRM em uso");

		profissional.setStatus(StatusUsuario.ATIVO);
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
