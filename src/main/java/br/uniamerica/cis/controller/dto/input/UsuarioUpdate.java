package br.uniamerica.cis.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;

import br.uniamerica.cis.model.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioUpdate {
	

	@NotBlank @Size(min = 6, max = 255)
	private String senha;

	@Valid @NotNull
	private PessoaUserUpdate user;
	
	public Pessoa getUser() {
		return toEntity(user);
	}
	
	private Pessoa toEntity(PessoaUserUpdate user) {
		
		if(user == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, Pessoa.class);
	}	

}
