package br.uniamerica.cis.domain.model;

import javax.persistence.Entity;

@Entity
public class Profissional extends Usuario{
	
	private Long crm;

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}
	
	
}
