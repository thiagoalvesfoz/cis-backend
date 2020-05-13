package br.uniamerica.cis.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.exception.BusinessRuleException;
import br.uniamerica.cis.domain.model.Profissional;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository pRepository;
	
	@Autowired
	private UsuarioService uService;
	
	public Profissional adicionar(Profissional profissional) {		
		
		uService.validateUserEmail(profissional);
		
		Optional<Profissional> verifyCrm = pRepository.findByCrm(profissional.getCrm());
		
		if(verifyCrm.isPresent())
			throw new BusinessRuleException("Não é possível cadastrar. CRM em uso");

		profissional.setStatus(StatusUsuario.ATIVO);
		return pRepository.save(profissional);
	}
	
}
