package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@Pattern(regexp = "^[Mm|Ff]$", message = "Deve corresponder a M ou F")
	private String sexo;
	
	@NotBlank
	private String telefone;
	
	@Email
	@NotBlank
	private String email;
	
	private String crm;
	
	@Past
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	
	private Long especialidadeId;
	private String avatar;
}
