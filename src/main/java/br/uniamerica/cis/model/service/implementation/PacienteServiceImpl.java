package br.uniamerica.cis.model.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.PacienteRepository;
import br.uniamerica.cis.model.entity.Paciente;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.PacienteService;
import br.uniamerica.cis.model.service.PessoaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {
	
	private final PacienteRepository repository;
	private final PessoaService userService;
	
	@Override
	public Paciente save(Paciente paciente) {
		
		userService.validateUserEmail(paciente.getEmail());
		paciente.setCreatedAt(LocalDateTime.now());
		return repository.save(paciente);
	}

	@Override
	public List<Paciente> findAll() {
		return repository.findAll();
	}

	@Override
	public Paciente findById(Long id) {		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
