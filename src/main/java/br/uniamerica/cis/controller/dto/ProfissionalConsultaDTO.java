package br.uniamerica.cis.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalConsultaDTO {
	
	private Long id;
	private String nomeCompleto;
	private String telefone;
	private String imgUrl;
	private String crm;	
}
