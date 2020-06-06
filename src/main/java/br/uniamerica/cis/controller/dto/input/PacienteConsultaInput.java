package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteConsultaInput {
	
	@NotNull
	private Long id;
}
