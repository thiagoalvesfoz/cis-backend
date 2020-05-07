package br.uniamerica.cis.domain.service;

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
	
	public Profissional adicionar(Profissional profissional) {
		
		if(!profissional.getSexo().toUpperCase().equals("M")
			&& !profissional.getSexo().toUpperCase().equals("F")) {
			throw new BusinessRuleException("Genero invalido. Preencha o campo corretamente!");
		}
		
		profissional.setSexo(profissional.getSexo().toUpperCase());
		profissional.setStatus(StatusUsuario.ATIVO);
		return pRepository.save(profissional);
	}
	
}
