package br.uniamerica.cis.api.dto;

public class EspecialidadeDTO implements DTO {
	
	private Long id;
	private String nome;
	
	public EspecialidadeDTO() {
	}
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}
