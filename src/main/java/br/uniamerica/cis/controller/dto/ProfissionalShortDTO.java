package br.uniamerica.cis.controller.dto;

import br.uniamerica.cis.model.entity.Especialidade;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProfissionalShortDTO {
	
	private Long id;
	private String nomeCompleto;
	private String crm;
	private Especialidade Especialidade;
}
