package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;

@Entity
public class Paciente extends Usuario {
	
	private String cpf;
	private String apelido;
	
	@OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
	private Endereco endereco;

	public Paciente(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			StatusUsuario status,
			String cpf, 
			String password,
			String avatar,
			String apelido, 
			Endereco endereco) {
		
		super(nome, sobrenome, dataNascimento, sexo, telefone, email, password, avatar, status);
		this.cpf = cpf;
		this.apelido = apelido;
		this.endereco = endereco;
	}
	
	public Paciente() {
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
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Paciente other = (Paciente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
