package br.uniamerica.cis.model.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uniamerica.cis.infrastructure.repository.ClinicaRepository;
import br.uniamerica.cis.model.entity.Clinica;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.ClinicaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClinicaServiceImpl implements ClinicaService {
	
	private final ClinicaRepository repository;
	
	@Override
	public Clinica save(Clinica clinica) {		
		return repository.save(clinica);
	}


	@Override
	@Transactional(readOnly = true)
	public List<Clinica> findAll() {		
		return repository.findAll();
	}
	
	@Override
	public Clinica findById(Long id) {
		return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional(readOnly = true)
	public void findClinicById(Long id) {				
		Optional<Clinica> clinica = repository.findById(id);		
		if(!clinica.isPresent()) throw new ResourceNotFoundException(id);		
	}


	@Override
	public Clinica updateClinica(Long id, Clinica updated) {
		
		Clinica clinica = this.findById(id);
		
		if(updated.getNome() != null)
			clinica.setNome(updated.getNome());
		
		if(updated.getCnpj() != null)
			clinica.setCnpj(updated.getCnpj());
		
		if(updated.getBairro() != null)
			clinica.setBairro(updated.getBairro());
		
		if(updated.getLogradouro() != null)
			clinica.setLogradouro(updated.getLogradouro());
		
		return repository.save(clinica);
	}
}
