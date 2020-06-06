package br.uniamerica.cis.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteUpgradeInput extends  PessoaUserUpdate {	
	
	@Size(max = 80)
	private String apelido;		
	
	@Valid
	private EnderecoInput endereco;
}
