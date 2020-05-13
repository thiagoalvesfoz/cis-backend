package br.uniamerica.cis.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.api.dto.PacienteDTO;
import br.uniamerica.cis.api.dto.input.PacienteInput;
import br.uniamerica.cis.domain.exception.ResourceNotFoundException;
import br.uniamerica.cis.domain.model.Endereco;
import br.uniamerica.cis.domain.model.Paciente;
import br.uniamerica.cis.domain.repository.PacienteRepository;
import br.uniamerica.cis.domain.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Pacientes")
@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository usuarioRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo paciente")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	private PacienteDTO adicionar(@Valid @RequestBody PacienteInput user) {
		Paciente novoPaciente = toEntity(user);
		return toModel(pacienteService.salvar(novoPaciente));
	}
	
	@ApiOperation("Retorna todos os pacientes")
	@GetMapping
	private List <PacienteDTO> listar(){
		// fazer paginação ...
		return toCollectionModel(usuarioRepository.findAll());
	}
	
	@ApiOperation("Retorna um paciente por id")
	@GetMapping("/{pacienteId}")
	private ResponseEntity <PacienteDTO> buscar(@PathVariable Long pacienteId){
		
		Paciente user = usuarioRepository.findById(pacienteId)
				.orElseThrow(() -> new ResourceNotFoundException(pacienteId));
		
		return ResponseEntity.ok().body(toModel(user));
	}
	
	@GetMapping("/{id}/endereco")
	private ResponseEntity<Endereco> findEndereco(@PathVariable Long id){
		
		Paciente user = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		
		return ResponseEntity.ok().body(user.getEndereco());
	}
	
	
	//converte uma objeto entidade para um modelo representacional
	private PacienteDTO toModel(Paciente user) {
		return modelMapper.map(user, PacienteDTO.class);
	}
	
	//converte um modelo representacional para um objeto entitade
	private Paciente toEntity(PacienteInput user) {
		return modelMapper.map(user, Paciente.class);
	}
	
	private List<PacienteDTO> toCollectionModel(List<Paciente> users){
		return users.stream().map( usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
	
	
}
