package br.uniamerica.cis.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.model.Usuario;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.UsuarioRepository;

@Service
public class UsuarioService  {
	
	@Autowired
	private UsuarioRepository uRepository;
	
	public Usuario salvar(Usuario user) {
		user.setStatus(StatusUsuario.ATIVO);
		return uRepository.save(user);
	}
}
