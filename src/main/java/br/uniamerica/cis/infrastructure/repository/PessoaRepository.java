package br.uniamerica.cis.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long > {
	Optional<Pessoa> findByEmail(String email);
}
