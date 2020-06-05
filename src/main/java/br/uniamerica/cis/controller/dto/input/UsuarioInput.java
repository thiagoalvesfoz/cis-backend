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
public class UsuarioInput {
	
	@NotBlank
	private String admin;
	
	@NotBlank @Size(min = 6, max = 255)
	private String senha;
	
	@NotBlank @Size(max = 15)
	private String tipo;

	@Valid @NotNull
	private PessoaInput user;
	
	//@NotNull
	//private Long clinicaId;
	
	public Pessoa getUser() {
		return toEntity(user);
	}
	
	private Pessoa toEntity(PessoaInput user) {
		
		if(user == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, Pessoa.class);
	}

}
