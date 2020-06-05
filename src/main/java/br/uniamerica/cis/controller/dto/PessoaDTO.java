package br.uniamerica.cis.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PessoaDTO {
	
	private Long id;
	private String nomeCompleto;
	private String nome;
	private String sobrenome;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	private String sexo;
	private String telefone;	
	private String email;
	private String imgUrl;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime createdAt;	
}
