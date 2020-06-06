package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteUpgradeInput {
	
	@NotBlank @Size(max = 45)
	private String nome;
	
	@NotBlank
	@Size(max = 60)
	private String sobrenome;
	
	@Size(max = 80)
	private String apelido;
	
	@NotBlank
	@Pattern(regexp = "^[Mm|Ff]$", message = "Deve corresponder a M ou F")
	private String sexo;
	
	@Past
	@NotNull
	@JsonFormat( pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	
	@Size(max = 15)
	private String telefone;
	private String imgUrl;
	
	@Valid
	private EnderecoInput endereco;
}
