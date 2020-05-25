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

public class PacienteInput {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@Past
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	@NotBlank
	@Pattern(regexp = "^[Mm|Ff]$", message = "Deve corresponder a M ou F")
	private String sexo;
	@NotBlank
	private String telefone;
	@Email
	@NotBlank
	private String email;
//	@CPF
	@NotBlank
	private String cpf;
	private String apelido;
	private EnderecoInput endereco;

	public PacienteInput() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Endereco getEndereco() {
		return toEntity(endereco);
	}

	public void setEndereco(EnderecoInput endereco) {
		this.endereco = endereco;
	}
	
	private Endereco toEntity(EnderecoInput endereco) {
		
		if(endereco == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(endereco, Endereco.class);
	}
}

