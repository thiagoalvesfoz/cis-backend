package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Pessoa;

public interface PessoaService {
	
	Pessoa save(Pessoa user);
	List<Pessoa> findAll();
	Pessoa getUser(Long id);
	void validateUserEmail(String email);

}
