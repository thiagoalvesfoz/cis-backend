package br.uniamerica.cis.api.controller;

import java.util.List;
import java.util.Optional;
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

import br.uniamerica.cis.api.dto.ProfissionalDTO;
import br.uniamerica.cis.api.dto.input.ProfissionalInput;
import br.uniamerica.cis.domain.model.Profissional;
import br.uniamerica.cis.domain.repository.ProfissionalRepository;
import br.uniamerica.cis.domain.service.ProfissionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Profissionais")
@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalRepository pRepository;
	
	@Autowired
	private ProfissionalService pService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo profissional")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private ProfissionalDTO criar(@Valid @RequestBody ProfissionalInput p) {
		return toModel(pService.adicionar(toEntity(p)));
	}
	
	@ApiOperation("Retorna todos os profissionais")
	@GetMapping
	private List<ProfissionalDTO> listar(){
		// fazer paginação aqui. motivo: economizar banda
		return toCollectionModel(pRepository.findAll());
	}
	
	@ApiOperation("Busca um profissional por id")
	@GetMapping("{profissionalId}")
	private ResponseEntity<ProfissionalDTO> buscar(@PathVariable Long profissionalId) {
		
		Optional<Profissional> p = pRepository.findById(profissionalId);
		
		if(p.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(toModel(p.get()));
		
	}
	
	
	private Profissional toEntity(ProfissionalInput p) {
		return modelMapper.map(p, Profissional.class);
	}
	
	private ProfissionalDTO toModel(Profissional p) {
		return modelMapper.map(p, ProfissionalDTO.class);
	}
	
	private List<ProfissionalDTO> toCollectionModel(List<Profissional> p){
		return p.stream().map(x -> toModel(x)).collect(Collectors.toList());
	}
	
}
