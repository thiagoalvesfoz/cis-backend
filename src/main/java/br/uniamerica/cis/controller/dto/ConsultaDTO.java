package br.uniamerica.cis.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultaDTO {	
	
	private Long id;
	private String observação;
	private String status;
	//private String createFrom;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime dataInicio;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime dataFim;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime createAt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime lastChange;	

	private PacienteConsultaDTO paciente;	
	private ProfissionalConsultaDTO profissional;	
	private ServicoConsultaDTO servico;
}
