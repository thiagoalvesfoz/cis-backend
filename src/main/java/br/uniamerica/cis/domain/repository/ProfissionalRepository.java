package br.uniamerica.cis.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.domain.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
	Optional<Profissional> findByCrm(Long crm);
}
