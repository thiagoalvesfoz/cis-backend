package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.UsuarioRepository;
import br.uniamerica.cis.model.entity.Usuario;
import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario save(Usuario user) {
		
		validateUserEmail(user.getEmail());
		
		user.setStatus(StatusUsuario.ATIVO);
		return repository.save(user);
	}


	@Override
	public List<Usuario> findAll() {		
		return repository.findAll();
	}

	@Override
	public Usuario getUser(Long id) {		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Override
	public void validateUserEmail(String email) {		
		
		Optional<Usuario> existente = repository.findByEmail(email);		
		
		if(existente.isPresent()) {
			throw new BusinessRuleException("Já existe um usuário com este e-mail "
					+ "cadastrado. E-mail: " + existente.get().getEmail());
		}
	}
}
