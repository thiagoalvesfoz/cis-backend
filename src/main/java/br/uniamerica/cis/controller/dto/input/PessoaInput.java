package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PessoaInput {
	
	@NotBlank @Size(min = 2, max = 60)
	private String nome;
	@NotBlank @Size(min = 2, max = 60)
	private String sobrenome;
	
	@Past
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	
	@NotBlank
	@Pattern(regexp = "^[Mm|Ff]$", message = "Deve corresponder a M ou F")
	private String sexo;
	
	@NotBlank @Size(min = 8, max = 15)
	private String telefone;

	@Email @Size(max = 60)
	private String email;
	
	@Size(max = 255)
	private String imgUrl;	
}

