package br.uniamerica.cis.controller.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.EspecialidadeDTO;
import br.uniamerica.cis.controller.dto.input.EspecialidadeInput;
import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.entity.Servico;
import br.uniamerica.cis.model.service.EspecialidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Especialidades")
@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController{

	private final EspecialidadeService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Retorna uma lista de especialidades")
	@GetMapping 
	public CollectionModel<EntityModel<EspecialidadeDTO>> all(){
		List<EntityModel<EspecialidadeDTO>> especialidades = toCollectionModel(service.findAll());		
		return new CollectionModel<>(especialidades, 
				linkTo(methodOn(EspecialidadeController.class).all()).withSelfRel());
	}
	
	@ApiOperation("Retorna uma lista de serviços associados uma especialidade")
	@GetMapping("/{id}/servicos")
	public List<Servico> allList(@PathVariable Long id){
		return service.findAllServices(id);
	}
	
	@ApiOperation("Retorna uma única especialidade")
	@GetMapping("/{id}")
	public EntityModel<EspecialidadeDTO> one(@PathVariable Long id) {		
		Especialidade especialidade = service.findById(id);
		return toModel(especialidade);
	}
	
	@ApiOperation("Cria uma nova especialidade")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntityModel<EspecialidadeDTO> create(@RequestBody EspecialidadeInput dto){		
		Especialidade esp = toEntity(dto);
		return toModel(service.save(esp));
	}
	
	@ApiOperation("Atualiza os dados da especialidade cadastrada")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody EspecialidadeInput dto) {
		service.atualizar(id, dto.getNome());
	}
	
	
	
	// Converts
	
	private Especialidade toEntity(EspecialidadeInput dto) {
		return modelMapper.map(dto, Especialidade.class);
	}	
	
	private EntityModel<EspecialidadeDTO> toModel(Especialidade entity) {
		EspecialidadeDTO dtoEntity = modelMapper.map(entity, EspecialidadeDTO.class);
		return new EntityModel<>(dtoEntity, 
				linkTo(methodOn(EspecialidadeController.class).one(dtoEntity.getId())).withSelfRel(),
				linkTo(methodOn(EspecialidadeController.class).all()).withRel("especialidades"));	
	}
	
	private List<EntityModel<EspecialidadeDTO>> toCollectionModel(List<Especialidade> list){	
		return list.stream()
				.map(objeto -> toModel(objeto))
				.collect(Collectors.toList());
	}
	
}
