package br.uniamerica.cis.api.controller;

import java.util.List;
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

import br.uniamerica.cis.api.dto.UsuarioDTO;
import br.uniamerica.cis.api.dto.input.UsuarioInput;
import br.uniamerica.cis.domain.exception.ResourceNotFoundException;
import br.uniamerica.cis.domain.model.Usuario;
import br.uniamerica.cis.domain.repository.UsuarioRepository;
import br.uniamerica.cis.domain.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Usuários")
@RestController // Pq estou utilizando Rest
@RequestMapping("/usuarios")// Busca os usuarios
public class UsuarioController {
	
	@Autowired // serve pra injecao de idependencia, as classes ficam menos dependentes uma da outro desacoplota
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo usuário")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	private UsuarioDTO adicionar(@Valid @RequestBody UsuarioInput user) {
		Usuario novoUsuario = toEntity(user);
		return toModel(usuarioService.salvar(novoUsuario));
	}
	
	@ApiOperation("Retorna todos os usuários")
	@GetMapping
	private List <UsuarioDTO> listar(){
		// fazer paginação ...
		return toCollectionModel(usuarioRepository.findAll());
	}
	
	@ApiOperation("Retorna um usuário por id")
	@GetMapping("/{usuarioId}")
	private ResponseEntity <UsuarioDTO> buscar(@PathVariable Long usuarioId){
		
		Usuario user = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException(usuarioId));
		
		return ResponseEntity.ok().body(toModel(user));
	}
	
	
	
	
	//converte uma objeto entidade para um modelo representacional
	private UsuarioDTO toModel(Usuario user) {
		return modelMapper.map(user, UsuarioDTO.class);
	}
	
	//converte um modelo representacional para um objeto entitade
	private Usuario toEntity(UsuarioInput user) {
		return modelMapper.map(user, Usuario.class);
	}
	
	private List<UsuarioDTO> toCollectionModel(List<Usuario> users){
		return users.stream().map( usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
}
