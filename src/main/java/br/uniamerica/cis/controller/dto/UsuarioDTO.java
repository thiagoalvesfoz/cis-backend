package br.uniamerica.cis.controller.dto;

import org.modelmapper.ModelMapper;

import br.uniamerica.cis.model.entity.Clinica;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioDTO {
	
	private Long id;
	private String tipo;
	private String status;
	private Boolean admin;
	private PessoaDTO user;
	private Clinica clinica;
	
	
	public PessoaDTO getUser() {
		return toEntity(user);
	}
	
	private PessoaDTO toEntity(PessoaDTO user) {
		
		if(user == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, PessoaDTO.class);
	}
}
