package br.uniamerica.cis.controller.dto.input;

import javax.validation.constraints.NotBlank;

import br.uniamerica.cis.controller.config.ValueOfEnum;
import br.uniamerica.cis.model.entity.enumeration.StatusConsulta;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ConsultaStatusInput {
	
	@NotBlank
	@ValueOfEnum(enumClass = StatusConsulta.class)
	private String status;
}
