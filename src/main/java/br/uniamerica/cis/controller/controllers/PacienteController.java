package br.uniamerica.cis.controller.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.PacienteDTO;
import br.uniamerica.cis.controller.dto.input.PacienteInput;
import br.uniamerica.cis.controller.dto.input.PacienteUpgradeInput;
import br.uniamerica.cis.model.entity.Paciente;
import br.uniamerica.cis.model.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Pacientes")
@RestController
@RequestMapping("pacientes")
@RequiredArgsConstructor
public class PacienteController {	

	private final PacienteService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo paciente")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	private EntityModel<PacienteDTO> adicionar(@Valid @RequestBody PacienteInput user) {
		return toModel(service.save(toEntity(user)));
	}
	
	@ApiOperation("Retorna todos os pacientes")
	@GetMapping
	public CollectionModel<EntityModel<PacienteDTO>> all(){
		List<EntityModel<PacienteDTO>> p = toCollectionModel(service.findAll());
		
		return new CollectionModel<>(p, 
				linkTo(methodOn(PacienteController.class).all()).withSelfRel());
	}
	
	@ApiOperation("Retorna um paciente específico")
	@GetMapping("/{id}")
	public EntityModel<PacienteDTO> one(@PathVariable Long id){		
		Paciente user = service.findById(id);		
		return toModel(user);
	}
	
	@ApiOperation("Atualiza as informações do paciente")
	@PutMapping("/{id}")
	public EntityModel<PacienteDTO> upgrade(@PathVariable Long id, @Valid @RequestBody PacienteUpgradeInput body) {
		Paciente paciente = service.upgradePaciente(id, toEntity(body));
		return toModel(paciente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
	// -------------------------------------------------------------- //
	
	private Paciente toEntity(Object user) {
		return modelMapper.map(user, Paciente.class);
	}	

	public EntityModel<PacienteDTO> toModel(Paciente entity) {
		PacienteDTO dtoEntity = modelMapper.map(entity, PacienteDTO.class);
		return new EntityModel<>(dtoEntity, 
				linkTo(methodOn(PacienteController.class).one(dtoEntity.getId())).withSelfRel(),
				linkTo(methodOn(PacienteController.class).all()).withRel("pacientes"));	
	}
	
	public List<EntityModel<PacienteDTO>> toCollectionModel(List<Paciente> list){
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	
}
