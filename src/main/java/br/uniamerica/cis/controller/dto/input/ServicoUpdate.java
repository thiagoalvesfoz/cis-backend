package br.uniamerica.cis.controller.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServicoUpdate {
	
	@NotBlank @Size(max = 255)
	private String nome;	
	
	@Digits(integer= 4, fraction= 2)
	private BigDecimal preco;
}
