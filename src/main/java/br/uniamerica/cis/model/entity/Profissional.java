package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;

@Entity
public class Profissional extends Usuario {
	
	private Long crm;
	private String tipoProfissional;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
	private Especialidade especialidade;
	
	public Profissional() {
	}

	public Profissional(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			String password,
			String avatar,
			StatusUsuario status,
			Long crm) {
		
		super(nome, sobrenome, dataNascimento, sexo, telefone, email,password, avatar, status);
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		return true;
	}
	
	
}
