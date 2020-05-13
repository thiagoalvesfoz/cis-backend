package br.uniamerica.cis.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.exception.BusinessRuleException;
import br.uniamerica.cis.domain.model.Paciente;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.PacienteRepository;

@Service
public class PacienteService  {
	
	@Autowired
	private PacienteRepository pRepository;
	
	public Paciente salvar(Paciente paciente) {
		
		Optional<Paciente> existente = pRepository.findByEmail(paciente.getEmail());
		
		if(existente.isPresent())
			throw new BusinessRuleException("Já existe um usuário com este e-mail cadastrado. E-mail: "
					+ existente.get().getEmail());
		
		paciente.setStatus(StatusUsuario.ATIVO);
		return pRepository.save(paciente);
	}
}
