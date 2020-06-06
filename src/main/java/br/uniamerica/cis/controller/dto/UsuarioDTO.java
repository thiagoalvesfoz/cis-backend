package br.uniamerica.cis.controller.dto;

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
}
