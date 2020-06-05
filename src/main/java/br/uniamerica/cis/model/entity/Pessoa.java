package br.uniamerica.cis.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pessoa_id")
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	
	@Transient
	private String nomeCompleto;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false, length = 1)
	private String sexo;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(nullable = false, length = 70)
	private String email;
	private String imgUrl;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
	pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime createdAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;	
	
	public Pessoa(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			String password,
			String avatar,
			Endereco endereco,
			StatusUsuario status) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.imgUrl = avatar;
		this.endereco = endereco;
		this.createdAt = LocalDateTime.now();
	}
	
	public String getNomeCompleto() {
		return this.nome + " " + this.sobrenome;
	}
	
	public String getSexo() {
		return this.sexo.toUpperCase();
	}
}
