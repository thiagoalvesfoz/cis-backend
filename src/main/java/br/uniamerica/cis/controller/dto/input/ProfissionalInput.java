package br.uniamerica.cis.controller.dto.input;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	

}
