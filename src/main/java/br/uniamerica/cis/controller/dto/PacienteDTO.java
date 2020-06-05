package br.uniamerica.cis.controller.dto;

import br.uniamerica.cis.model.entity.Endereco;
import br.uniamerica.cis.model.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteDTO extends Pessoa {
	
	private Long id;	
	private String cpf;
	private String apelido;	
	private Endereco endereco;
}
