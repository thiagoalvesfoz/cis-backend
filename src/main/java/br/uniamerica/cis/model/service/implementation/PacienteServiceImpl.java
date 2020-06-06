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
				.orElseThrow(() -> new ResourceNotFoundException("Id do paciente não encontrado"));
	}

	@Override
	public Paciente upgradePaciente(Long id, Paciente upgraded) {
		
		var paciente = this.findById(id);
		
		if( !upgraded.getNome().equals( paciente.getNome() ))
			paciente.setNome(upgraded.getNome());
		
		if( !upgraded.getSobrenome().equals( paciente.getSobrenome() ))
			paciente.setSobrenome(upgraded.getSobrenome());
		
		if( !upgraded.getSexo().equals( paciente.getSexo() ))
			paciente.setSexo(upgraded.getSexo());
		
		if( !upgraded.getDataNascimento().equals( paciente.getDataNascimento() ))
			paciente.setDataNascimento(upgraded.getDataNascimento());		

		paciente.setApelido(upgraded.getApelido());
		paciente.setEndereco(upgraded.getEndereco());
		paciente.setTelefone(upgraded.getTelefone());
		paciente.setImgUrl(upgraded.getImgUrl());		
		
		return repository.save(paciente);
	}

	@Override
	public void delete(Long id) {		
		var paciente = this.findById(id);
		repository.delete(paciente);		
	}
}
