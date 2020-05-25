package br.uniamerica.cis.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Especialidade {
	
	@Id
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Setter
	private String nome;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "especialidade")
	private List<Profissional> profissional = new ArrayList<>();
	// vários profissionais podem ter uma especialidade em comum
	
	public Especialidade(String nome) {
		this.nome = nome;
	}
}
