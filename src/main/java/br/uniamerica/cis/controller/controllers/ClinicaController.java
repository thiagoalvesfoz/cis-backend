package br.uniamerica.cis.controller.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.input.ClinicaInput;
import br.uniamerica.cis.model.entity.Clinica;
import br.uniamerica.cis.model.service.ClinicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Clínica")
@RequiredArgsConstructor
@RestController
@RequestMapping("/clinicas")
public class ClinicaController {
	
	private final ClinicaService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Faz o registro da clinica no sistema")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clinica adicionar(@RequestBody Clinica clinica) {
		return service.save(clinica);
	}
	
	
	@ApiOperation("Lista todas as clinicas")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Clinica> listAll(){
		return service.findAll();
	}
	
	
	@ApiOperation("Busca uma clinica específica")
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Clinica findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
	@ApiOperation("Atualizar os dados cadastrados")
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Clinica atualizarClinica(@PathVariable Long id, 
									@Valid @RequestBody ClinicaInput clinica) {
		
		return service.updateClinica(id, toEntity(clinica));
	}
	
	private Clinica toEntity(ClinicaInput clinica) {
		return modelMapper.map(clinica, Clinica.class);
	}
	

}
