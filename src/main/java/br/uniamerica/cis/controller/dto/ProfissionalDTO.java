package br.uniamerica.cis.controller.dto;

public class ProfissionalDTO {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String crm;
	private String email;
	private String telefone;
	private String especialidadeNome;
	private String avatar;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidadeNome() {
		return especialidadeNome;
	}

	public void setEspecialidadeNome(String especialidadeNome) {
		this.especialidadeNome = especialidadeNome;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
