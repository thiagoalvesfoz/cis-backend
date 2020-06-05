package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();
	Usuario updateUser(Long id, Usuario user);
	Usuario save(Usuario user);
	Usuario getUser(Long id);
	void updateStatus(Long id, String status);
}
