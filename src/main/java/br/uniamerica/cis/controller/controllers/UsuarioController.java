package br.uniamerica.cis.controller.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.uniamerica.cis.controller.dto.UsuarioDTO;
import br.uniamerica.cis.controller.dto.input.UsuarioInput;
import br.uniamerica.cis.model.entity.Pessoa;
import br.uniamerica.cis.model.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Usuários")
@RestController 
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {	
	
	private final PessoaService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo usuário")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	private UsuarioDTO adicionar(@Valid @RequestBody UsuarioInput user) {
		Pessoa novoUsuario = toEntity(user);
		return toModel(service.save(novoUsuario));
	}
	
	@ApiOperation("Retorna todos os usuários")
	@GetMapping
	private List <UsuarioDTO> listar(){
		return toCollectionModel(service.findAll());
	}
	
	@ApiOperation("Retorna um usuário por id")
	@GetMapping("/{id}")
	private ResponseEntity <UsuarioDTO> buscar(@PathVariable Long id){
		Pessoa user = service.getUser(id);
		return ResponseEntity.ok().body(toModel(user));
	}
	
	//converte uma entidade para um modelo representacional
	private UsuarioDTO toModel(Pessoa user) {
		return modelMapper.map(user, UsuarioDTO.class);
	}
	
	//converte um modelo representacional para um objeto entitade
	private Pessoa toEntity(UsuarioInput user) {
		return modelMapper.map(user, Pessoa.class);
	}
	
	
	//converte uma lista de entidades para uma lista de DTOs
	private List<UsuarioDTO> toCollectionModel(List<Pessoa> users){
		return users.stream().map( usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
}
