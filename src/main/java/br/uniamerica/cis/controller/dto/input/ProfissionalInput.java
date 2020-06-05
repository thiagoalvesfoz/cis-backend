package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalInput extends PessoaInput {	
	
	@NotBlank
	private String crm;
	private Long especialidadeId;
}
