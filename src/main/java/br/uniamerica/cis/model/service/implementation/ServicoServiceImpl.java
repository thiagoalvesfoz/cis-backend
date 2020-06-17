package br.uniamerica.cis.model.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uniamerica.cis.infrastructure.repository.ServicoRepository;
import br.uniamerica.cis.model.entity.Servico;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.ServicoService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {
	//entity.setId(null); //bug modelMapper
	private final ServicoRepository repository;
	
	@Override
	public List<Servico> findAllServices() {		
		return repository.findAll();
	}

	@Override
	public Servico save(Servico entity) {
		if(entity.getId() != null) entity.setId(null);
		repository.save(entity);
		return this.findServiceById(entity.getId());
	}

	@Override
	public Servico findServiceById(Long id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("Serviço nao encontrado") );
	}
	
	@Override
	public Servico updated(Long id, Servico updated) {
		
		var entity = this.findServiceById(id);
		
		if(updated.getNome() != null )
			entity.setNome(updated.getNome());
		
		if(updated.getPreco() != null)
			entity.setPreco(updated.getPreco());		
		
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);		
	}

}
