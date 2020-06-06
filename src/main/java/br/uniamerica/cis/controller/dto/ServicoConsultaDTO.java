package br.uniamerica.cis.controller.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServicoConsultaDTO {	
	private String servicoNome;
	private BigDecimal servicoPreco;
	private String especialidadeNome;
}
