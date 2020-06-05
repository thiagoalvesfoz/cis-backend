package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClinicaInput {
	
	@NotBlank @Size(min = 2, max = 80)
	private String nome;
	
	@NotBlank @Size(max = 18)
	private String cnpj;
	
	@Size(max = 255)
	private String logradouro;
	
	@Size(max = 255)
	private String bairro;
	
}
