package br.uniamerica.cis.domain.model;

import java.util.Date;

import javax.persistence.Entity;

import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;

@Entity
public class Profissional extends Usuario{
	
	private Long crm;
	
	public Profissional() {
	}

	public Profissional(String nome, 
			String sobrenome, 
			Date dataNascimento, 
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
	
	
}
