package br.uniamerica.cis.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Especialidade;
import br.uniamerica.cis.model.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long > {
	List<Servico> findByEspecialidade(Especialidade especialidade);
	
}
