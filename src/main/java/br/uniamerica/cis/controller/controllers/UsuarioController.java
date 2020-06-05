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

import br.uniamerica.cis.controller.dto.UsuarioDTO;
import br.uniamerica.cis.controller.dto.input.UsuarioInput;
import br.uniamerica.cis.controller.dto.input.UsuarioStatusInput;
import br.uniamerica.cis.controller.dto.input.UsuarioUpdate;
import br.uniamerica.cis.model.entity.Usuario;
import br.uniamerica.cis.model.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api("Usuários")
@RestController 
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {	
	
	private final UsuarioService service;
	private final ModelMapper modelMapper;
	
	@ApiOperation("Cria um novo usuário no sistema")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) 
	private UsuarioDTO adicionar(@Valid @RequestBody UsuarioInput user) {
		Usuario entity = service.save(toEntity(user));
		return toModel(entity);
	}
	
	@ApiOperation("Lista todos os usuários")
	@GetMapping
	@ResponseStatus(HttpStatus.OK) 
	private List <UsuarioDTO> listar(){
		return toCollectionModel(service.findAll());
	}
	
	@ApiOperation("Retorna um usuário por id")
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK) 
	private UsuarioDTO buscar(@PathVariable Long id){
		
		Usuario user = service.getUser(id);
		return toModel(user);
	}
	
	@ApiOperation("Atualiza as informações do usuário")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK) 
	private UsuarioDTO atualizar(@PathVariable Long id, 
						  		@RequestBody UsuarioUpdate atualizado){
		
		Usuario user = service.updateUser( id , toEntity( atualizado ) );
		
		return toModel(user);
	}
	
	@ApiOperation("Altera o status do usuário no sistema")
	@PutMapping("/{id}/atualizar-status")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	private void atualizarStatus(@PathVariable Long id, 
								 @Valid @RequestBody UsuarioStatusInput user){
		
		service.updateStatus(id, user.getStatus());
	}
	
	
	//conversões dto
	
	private UsuarioDTO toModel(Usuario user) {
		return modelMapper.map(user, UsuarioDTO.class);
	}
	
	private <U extends Object> Usuario toEntity(U user) {
		return modelMapper.map(user, Usuario.class);
	}
	
	
	private List<UsuarioDTO> toCollectionModel(List<Usuario> users){
		return users.stream().map( usuario -> toModel(usuario))
				.collect(Collectors.toList());
	}
}
