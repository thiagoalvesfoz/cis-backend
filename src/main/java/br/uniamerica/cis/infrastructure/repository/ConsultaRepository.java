package br.uniamerica.cis.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
