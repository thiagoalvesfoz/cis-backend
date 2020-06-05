package br.uniamerica.cis.model.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.UsuarioRepository;
import br.uniamerica.cis.model.entity.Usuario;
import br.uniamerica.cis.model.entity.enumeration.StatusUsuario;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.PessoaService;
import br.uniamerica.cis.model.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository repository;
	private final PessoaService pessoaService;
	//private final ClinicaService clinicaService;
	
	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	@Override	
	public Usuario save(Usuario user) {
		
		// valida existencia da clinica
		//clinicaService.findClinicById(user.getClinica().getId());
		
		pessoaService.validateUserEmail(user.getUser().getEmail());	
		
		user.getUser().setCreatedAt(LocalDateTime.now());		
		user.setStatus(StatusUsuario.ATIVO);
		
		return repository.save(user);
	}
	
	@Override
	public Usuario getUser(Long id) {
		return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
	}

	@Override
	public Usuario updateUser(Long id, Usuario atualizado) {		
		
		Usuario UsuarioExistente = this.getUser(id);
		
		if(atualizado.getSenha() != null) {
			UsuarioExistente.setSenha(atualizado.getSenha());
			UsuarioExistente = repository.save(UsuarioExistente);			
		}
		
		var idPessoa = UsuarioExistente.getUser().getId();
		var pessoa = atualizado.getUser();
		
		pessoaService.update(idPessoa, pessoa);
		
		var user = this.getUser(id);	
		
		return user;
	}
	
	@Override
	public void updateStatus(Long id, String status) {
		
		var user = this.getUser(id);
		
		if(!status.equals(StatusUsuario.ATIVO.name()) 
		&& !status.equals(StatusUsuario.INATIVO.name()))
			throw new BusinessRuleException("O status é inválido.");		
			
		user.setStatus(StatusUsuario.valueOf(status));		
		repository.save(user);
	}
	
	

}
