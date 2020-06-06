package br.uniamerica.cis.controller.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServicoInput {
	
	@NotBlank @Size(max = 100)
	private String nome;
	
	@Digits(integer= 4, fraction= 2)
	private BigDecimal preco;
	
	@NotNull
	private Long especialidadeId;
}
