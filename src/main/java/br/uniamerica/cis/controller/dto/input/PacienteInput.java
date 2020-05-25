package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.uniamerica.cis.model.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Setter
public class PacienteInput {
	
	@Getter
	@NotBlank
	private String nome;
	
	@Getter
	@NotBlank
	private String sobrenome;
	
	@Getter
	@Past
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	
	@Getter
	@NotBlank
	@Pattern(regexp = "^[Mm|Ff]$", message = "Deve corresponder a M ou F")
	private String sexo;
	
	@Getter
	@NotBlank
	private String telefone;
	
	@Getter
	@Email
	@NotBlank
	private String email;
	
//	@CPF
	@Getter
	@NotBlank
	private String cpf;
	
	@Getter
	private String apelido;
	
	private EnderecoInput endereco;	

	public Endereco getEndereco() {
		return toEntity(endereco);
	}
	
	private Endereco toEntity(EnderecoInput endereco) {
		
		if(endereco == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(endereco, Endereco.class);
	}
}

