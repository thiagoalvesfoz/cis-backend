package br.uniamerica.cis.controller.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoInput {
	
	private String cep;
	private Long numero;
	private String Logradouro;	
}
