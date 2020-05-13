package br.uniamerica.cis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.model.Paciente;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.PacienteRepository;

@Service
public class PacienteService  {
	
	@Autowired
	private PacienteRepository pRepository;
	
	@Autowired
	private UsuarioService userService;
	
	public Paciente salvar(Paciente paciente) {
		
		userService.validateUserEmail(paciente);
		
		paciente.setStatus(StatusUsuario.ATIVO);
		return pRepository.save(paciente);
	}
}
