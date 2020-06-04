package br.uniamerica.cis.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalDTO {
	
	private Long id;
	private String nome;
	private String sobrenome;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	private String crm;
	private String email;
	private String telefone;
	private String especialidadeNome;
	private String avatar;	
}
