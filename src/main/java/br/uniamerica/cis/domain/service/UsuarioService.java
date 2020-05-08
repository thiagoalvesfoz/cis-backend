package br.uniamerica.cis.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.domain.exception.BusinessRuleException;
import br.uniamerica.cis.domain.model.Usuario;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.UsuarioRepository;

@Service
public class UsuarioService  {
	
	@Autowired
	private UsuarioRepository uRepository;
	
	public Usuario salvar(Usuario user) {
		
		Optional<Usuario> existente = uRepository.findByEmail(user.getEmail());
		
		if(existente.isPresent())
			throw new BusinessRuleException("Usuário já cadastrado");
		
		user.setStatus(StatusUsuario.ATIVO);
		return uRepository.save(user);
	}
}
