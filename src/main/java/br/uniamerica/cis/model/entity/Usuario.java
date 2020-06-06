package br.uniamerica.cis.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 15)
	private String tipo;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private StatusUsuario status;
	
	@Column(nullable = false)
	private Boolean admin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Pessoa user;
	
	
	//@ManyToOne
	//@JoinColumn(name = "id_clinica")
	//private Clinica clinica;
	
	
}
