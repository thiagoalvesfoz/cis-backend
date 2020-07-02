package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotBlank;

import br.uniamerica.cis.controller.config.ValueOfEnum;
import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioStatusInput {
	
	@NotBlank
	@ValueOfEnum(enumClass = StatusUsuario.class)
	private String status;

}
