package br.uniamerica.cis.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Consulta;
import br.uniamerica.cis.model.entity.Paciente;
import br.uniamerica.cis.model.entity.Profissional;
import br.uniamerica.cis.model.entity.Servico;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	
	Optional<Paciente> findPacienteById(Long id);
	Optional<Profissional> findProfissionalById(Long id);
	Optional<Servico> findConsultaById(Long id);

}
