package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultaInput {
	
	private String observação;	
	
	@NotBlank
	private String status;	
	
	@NotNull
	private LocalDateTime dataInicio;
	
	@NotNull
	private LocalDateTime dataFim;
	
	@NotNull
	private Long servicoId;
	
	@Valid @NotNull
	private PacienteConsultaInput paciente;	
	
	@Valid @NotNull
	private ProfissionalConsultaInput profissional;
	
	
	
	

}