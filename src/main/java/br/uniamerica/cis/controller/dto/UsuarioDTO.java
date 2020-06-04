package br.uniamerica.cis.controller.dto;

import org.modelmapper.ModelMapper;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {
	
	private Long id;
	private String tipo;
	private String status;
	private Boolean admin;
	private PessoaDTO user;
	
	
	public PessoaDTO getUser() {
		return toEntity(user);
	}
	
	private PessoaDTO toEntity(PessoaDTO user) {
		
		if(user == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, PessoaDTO.class);
	}
}
