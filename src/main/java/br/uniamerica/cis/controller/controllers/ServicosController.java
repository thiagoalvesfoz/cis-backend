package br.uniamerica.cis.controller.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import br.uniamerica.cis.controller.dto.input.ServicoInput;
import br.uniamerica.cis.controller.dto.input.ServicoUpdate;
import br.uniamerica.cis.model.entity.Servico;
import br.uniamerica.cis.model.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Serviços")
@RestController
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicosController {
	
	private final ServicoService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Lista todos os serviços")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Servico> findAll() {
		return service.findAllServices();		
	}
	
	@ApiOperation("Cria um novo serviço")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico create(@Valid @RequestBody ServicoInput servico) {
		return service.save(toEntity(servico));
	}
	
	@ApiOperation("Busca um serviço específico")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Servico One(@PathVariable Long id) {
		return service.findServiceById(id);
	}	
	
	@ApiOperation("Atualiza um serviço")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Servico update(@PathVariable Long id, @Valid @RequestBody ServicoUpdate body) {
		return service.updated(id, toEntity(body) );
	}
	
	@ApiOperation("Deleta um serviço")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteService(@PathVariable Long id) {
		service.delete(id);
	}
	
	private Servico toEntity(Object dto) {
		return modelMapper.map(dto, Servico.class);
	}
}
