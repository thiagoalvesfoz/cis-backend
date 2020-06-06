package br.uniamerica.cis.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteConsultaDTO {
	
	private Long id;
	private String nomeCompleto;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	private String sexo;
	private String telefone;
	private String email;
	private String apelido;
	
	
}
