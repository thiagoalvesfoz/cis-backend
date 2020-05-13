package br.uniamerica.cis.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.domain.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	Optional<Paciente> findByEmail(String email);
}
