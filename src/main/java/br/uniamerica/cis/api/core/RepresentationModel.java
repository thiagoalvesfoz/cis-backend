package br.uniamerica.cis.api.core;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;

import br.uniamerica.cis.api.controller.ControllerMethods;
import br.uniamerica.cis.api.dto.DTO;

public class RepresentationModel<C extends ControllerMethods<T>, T extends DTO> { // T -> DTO
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Class<C> controller;
	public Class<T> dto;
	
	public RepresentationModel(Class<T> dto, Class<C> controller) {
		this.controller = controller;
		this.dto = dto;
	}

	public EntityModel<T> toModel(Object entity) {
		T dtoEntity = modelMapper.map(entity, this.dto);
		System.out.println(dto);
		return new EntityModel<>(dtoEntity, 
				linkTo(methodOn(controller).one(dtoEntity.getId())).withSelfRel(),
				linkTo(methodOn(controller).all()).withRel(rel()));	
	}
	
	public List<EntityModel<T>> toCollectionModel(List<?> list){
	
		return list.stream()
				.map(objeto -> toModel(objeto))
				.collect(Collectors.toList());
	}
	
	private String rel() {
		return linkTo(methodOn(controller).all()).toUri().getPath().substring(1);
	}
	
	public void setController(Class<C> controller) {
		this.controller = controller;
	}
	
	public void setDto(Class<T> dto) {
		this.dto = dto;
	}


	
}
