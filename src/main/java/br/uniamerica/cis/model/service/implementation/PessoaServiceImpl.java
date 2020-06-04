package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.PessoaRepository;
import br.uniamerica.cis.model.entity.Pessoa;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.PessoaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl  implements PessoaService {
	
	private final PessoaRepository repository;
	
	@Override
	public Pessoa save(Pessoa user) {
		
		validateUserEmail(user.getEmail());
		return repository.save(user);
	}


	@Override
	public List<Pessoa> findAll() {		
		return repository.findAll();
	}

	@Override
	public Pessoa getUser(Long id) {		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@Override
	public void validateUserEmail(String email) {		
		
		Optional<Pessoa> existente = repository.findByEmail(email);		
		
		if(existente.isPresent()) {
			throw new BusinessRuleException("Já existe um usuário com este e-mail "
					+ "cadastrado. E-mail: " + existente.get().getEmail());
		}
	}
}
