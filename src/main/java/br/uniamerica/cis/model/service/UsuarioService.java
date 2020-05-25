package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Usuario;

public interface UsuarioService {
	
	Usuario save(Usuario user);
	List<Usuario> findAll();
	Usuario getUser(Long id);
	void validateUserEmail(String email);

}
