package br.uniamerica.cis.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalDTO extends PessoaDTO {	
	private Long crm;	
	private String especialidadeNome;
}
