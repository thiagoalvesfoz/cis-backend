package br.uniamerica.cis.model.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uniamerica.cis.infrastructure.repository.ConsultaRepository;
import br.uniamerica.cis.model.entity.Consulta;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.ConsultaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
	
	private final ConsultaRepository repository;

	@Override
	public Consulta createConsulta(Consulta entity) {
		return null;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Consulta> findAllConsultas() {
		return repository.findAll();
	}

	@Override
	public Consulta findConsultaById(Long id) {
		return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException(id) );
	}

}
