package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;
	private String nome;
	private String sobrenome;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dataNascimento;
	private String sexo;
	private String telefone;
	private String email;
	private String password;
	private String avatar;
	
	@Enumerated(EnumType.STRING)
	private StatusUsuario status;
	
	public Usuario(String nome, 
			String sobrenome, 
			LocalDate dataNascimento, 
			String sexo, 
			String telefone, 
			String email,
			String password,
			String avatar,
			StatusUsuario status) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.status = status;
	}	
}
