package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalInput extends PessoaInput {	
	
	@NotNull
	private String crm;
	
	@NotNull
	private Long especialidadeId;
}
