package br.uniamerica.cis.controller.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.EspecialidadeDTO;
import br.uniamerica.cis.controller.dto.input.EspecialidadeInput;
import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.service.EspecialidadeService;


@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController{
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private EspecialidadeService service;
	
	
	@GetMapping 
	public CollectionModel<EntityModel<EspecialidadeDTO>> all(){
		List<EntityModel<EspecialidadeDTO>> especialidades = toCollectionModel(service.findAll());		
		return new CollectionModel<>(especialidades, 
				linkTo(methodOn(EspecialidadeController.class).all()).withSelfRel());
	}
	

	@GetMapping("/{id}")
	public EntityModel<EspecialidadeDTO> one(@PathVariable Long id) {		
		Especialidade especialidade = service.findById(id);
		return toModel(especialidade);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	EntityModel<EspecialidadeDTO> create(@RequestBody EspecialidadeInput dto){		
		Especialidade esp = toEntity(dto);
		return toModel(service.save(esp));
	}
	
	
	// Converts
	
	private Especialidade toEntity(EspecialidadeInput dto) {
		return modelMapper.map(dto, Especialidade.class);
	}	
	
	public EntityModel<EspecialidadeDTO> toModel(Especialidade entity) {
		EspecialidadeDTO dtoEntity = modelMapper.map(entity, EspecialidadeDTO.class);
		return new EntityModel<>(dtoEntity, 
				linkTo(methodOn(EspecialidadeController.class).one(dtoEntity.getId())).withSelfRel(),
				linkTo(methodOn(EspecialidadeController.class).all()).withRel("especialidades"));	
	}
	
	public List<EntityModel<EspecialidadeDTO>> toCollectionModel(List<Especialidade> list){	
		return list.stream()
				.map(objeto -> toModel(objeto))
				.collect(Collectors.toList());
	}
	
}
