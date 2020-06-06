package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultaUpdateInput {


	private String observação;	
	
	@NotBlank
	private String status;	
	
	@NotNull
	private LocalDateTime dataInicio;
	
	@NotNull
	private LocalDateTime dataFim;

}
