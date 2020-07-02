package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Profissional extends Pessoa {
	
	@Column(nullable = false)
	private String crm;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id", nullable = true)	
	private Especialidade especialidade;


	public Profissional(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			String password,
			String avatar,
			StatusUsuario status,
			Endereco endereco,
			String crm) {
		
		super(nome, sobrenome, dataNascimento, sexo, telefone, email,password, avatar, endereco, status);
		this.crm = crm;
	}	
}
