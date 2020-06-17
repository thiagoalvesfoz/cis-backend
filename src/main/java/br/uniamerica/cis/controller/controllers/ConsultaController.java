package br.uniamerica.cis.controller.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import br.uniamerica.cis.controller.dto.ConsultaDTO;
import br.uniamerica.cis.controller.dto.input.ConsultaInput;
import br.uniamerica.cis.controller.dto.input.ConsultaStatusInput;
import br.uniamerica.cis.controller.dto.input.ConsultaUpdateInput;
import br.uniamerica.cis.model.entity.Consulta;
import br.uniamerica.cis.model.service.ConsultaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Consulta")
@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {
	
	private final ConsultaService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Cria uma nova consulta")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ConsultaDTO create(@Valid @RequestBody ConsultaInput dto) {
		
		//service.validateStatusConsulta(dto.getStatus());		
		Consulta consulta = service.createConsulta(toEntity(dto));	
		
		return toModel(consulta);
	}
	
	@ApiOperation("Lista todas as consultas marcadas")
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ConsultaDTO> All() {
		return toCollectionModel(service.findAllConsultas());
	}
	
	@ApiOperation("busca uma consulta marcada")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ConsultaDTO one(@PathVariable Long id) {
		return toModel(service.findConsultaById(id));
	}
	
	@ApiOperation("Atualiza informações de uma consulta marcada")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @Valid @RequestBody ConsultaUpdateInput dto) {
		service.updateConsulta(id, toEntity(dto));
	}
	
	@ApiOperation("Atualiza o status de uma consulta marcada")
	@PutMapping("/{id}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateStatusConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaStatusInput body) {		
		var status = body.getStatus();		
		//service.validateStatusConsulta(status);			
		service.updateStatus(id, status);
	}
	

	private Consulta toEntity(Object dto) {
		return modelMapper.map(dto, Consulta.class);
	}
	
	private ConsultaDTO toModel(Consulta entity) {
		return modelMapper.map(entity, ConsultaDTO.class);
	}
	
	private List<ConsultaDTO> toCollectionModel(List<Consulta> list) {
		return list.stream().map(this::toModel).collect(Collectors.toList());
	}
	
}
