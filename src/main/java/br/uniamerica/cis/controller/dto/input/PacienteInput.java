package br.uniamerica.cis.controller.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;

import br.uniamerica.cis.model.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PacienteInput extends PessoaInput {
	
	
//	@CPF 
	@NotBlank @Size(max = 11)
	private String cpf;
	
	@Getter @Size(max = 45)
	private String apelido;
	
	@Valid
	private EnderecoInput endereco;	

	public Endereco getEndereco() {
		return toEntity(endereco);
	}
	
	private Endereco toEntity(EnderecoInput endereco) {
		
		if(endereco == null) return null;
		
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(endereco, Endereco.class);
	}
}

