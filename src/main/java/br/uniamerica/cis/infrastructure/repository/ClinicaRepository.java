package br.uniamerica.cis.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
	
}
