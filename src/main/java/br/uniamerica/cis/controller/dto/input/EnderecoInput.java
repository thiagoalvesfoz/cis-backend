package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoInput {
	
	@NotBlank @Size(max = 50)
	private String cidade;
	@NotBlank @Size(max = 2)
	private String estado;
	@NotBlank @Size(max = 255)
	private String logradouro;	
}
