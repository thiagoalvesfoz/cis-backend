package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

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
public class Profissional extends Usuario {
	
	private Long crm;
	private String tipoProfissional;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
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
			Long crm) {
		
		super(nome, sobrenome, dataNascimento, sexo, telefone, email,password, avatar, status);
		this.crm = crm;
	}	
}
