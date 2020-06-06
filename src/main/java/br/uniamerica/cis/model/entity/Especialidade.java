package br.uniamerica.cis.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "especialidade")
	private List<Profissional> profissional = new ArrayList<>();
	// vários profissionais podem ter uma especialidade em comum
	
	@JsonIgnore
	@OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL)
	private List<Servico> servicos = new ArrayList<>();
	
	public Especialidade(String nome) {
		this.nome = nome;
	}
}
