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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.ProfissionalDTO;
import br.uniamerica.cis.controller.dto.ProfissionalShortDTO;
import br.uniamerica.cis.controller.dto.input.ProfissionalInput;
import br.uniamerica.cis.model.entity.Profissional;
import br.uniamerica.cis.model.service.ProfissionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Profissionais")
@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {	

	private final ProfissionalService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo profissional")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private EntityModel<ProfissionalDTO> criar(@Valid @RequestBody ProfissionalInput profissional) {
		return toModel(service.save(toEntity(profissional)));
	}
	
	@GetMapping
	@ApiOperation("Retorna todos os profissionais")
	@ResponseStatus(HttpStatus.OK)
	public CollectionModel<EntityModel<ProfissionalShortDTO>> all(){	
		
		List<EntityModel<ProfissionalShortDTO>> list = service.findAll()
				.stream().map(this::toModelShort).collect(Collectors.toList());	
		
		return new CollectionModel<>(list, 
				linkTo(methodOn(EspecialidadeController.class).all()).withSelfRel());
	}
	
	@ApiOperation("Retorna um profissional específico")
	@GetMapping("{id}")
	public EntityModel<ProfissionalDTO> one(@PathVariable Long id) {		
		Profissional profissional = service.findById(id);		
		return toModel(profissional);
	}
	
	
	///conversões
	private Profissional toEntity(ProfissionalInput entityDto) {
		return modelMapper.map(entityDto, Profissional.class);
	}
	
	public EntityModel<ProfissionalDTO> toModel(Profissional entity) {
		ProfissionalDTO dtoEntity = modelMapper.map(entity, ProfissionalDTO.class);
		return createLinks(dtoEntity, dtoEntity.getId());
	}
	
	public EntityModel<ProfissionalShortDTO> toModelShort(Profissional entity) {
		ProfissionalShortDTO dtoEntity = modelMapper.map(entity, ProfissionalShortDTO.class);
		return createLinks(dtoEntity, dtoEntity.getId());	
	}
	
	public List<EntityModel<ProfissionalDTO>> toCollectionModel(List<Profissional> list){
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}	
	
	//novo código
	protected <T> EntityModel<T> createLinks(T dtoEntity, Long id) {
		return new EntityModel<>(dtoEntity, 
				linkTo(methodOn(ProfissionalController.class).one(id)).withSelfRel(),
				linkTo(methodOn(ProfissionalController.class).all()).withRel("profissionais"));
	}	

}
