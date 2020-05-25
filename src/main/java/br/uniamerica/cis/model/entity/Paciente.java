package br.uniamerica.cis.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
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
}
