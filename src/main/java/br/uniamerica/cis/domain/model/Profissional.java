package br.uniamerica.cis.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;

@Entity
public class Profissional extends Usuario{
	
	private Long crm;
	private String tipoProfissional;
	private String descricao;
	
	public Profissional() {
	}

	public Profissional(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			StatusUsuario status,
			Long crm) {
		
		super(nome, sobrenome, dataNascimento, sexo, telefone, email, status);
		this.crm = crm;
	}


	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public String getTipoProfissional() {
		return tipoProfissional;
	}

	public void setTipoProfissional(String tipoProfissional) {
		this.tipoProfissional = tipoProfissional;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
