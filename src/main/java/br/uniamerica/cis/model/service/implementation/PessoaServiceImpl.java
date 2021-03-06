package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
				.orElseThrow(() -> new ResourceNotFoundException("Id do usuário não encontrado"));
	}
	
	@Override
	@Transactional(readOnly = true)
	public void validateUserEmail(String email) {
		
		Optional<Pessoa> existente = repository.findByEmail(email);		
		
		if(existente.isPresent())
			throw new BusinessRuleException("Já existe um usuário com este e-mail.");
	}


	@Override
	@Transactional
	public Pessoa update(Long id, Pessoa updated) {
		
		Pessoa pessoa = this.getUser(id);
		
		if(updated.getNome() != null) 
			pessoa.setNome(updated.getNome());
		
		if(updated.getSobrenome() != null) 
			pessoa.setSobrenome(updated.getSobrenome());
		
		if(updated.getDataNascimento() != null) 
			pessoa.setDataNascimento(updated.getDataNascimento());
		
		if(updated.getTelefone() != null) 
			pessoa.setTelefone(updated.getTelefone());
		
		if(updated.getSexo() != null) 
			pessoa.setSexo(updated.getSexo());
		
		if(updated.getImgUrl() != null) 
			pessoa.setImgUrl(updated.getImgUrl());		
		
		return repository.save(pessoa);
	}

}
