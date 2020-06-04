package br.uniamerica.cis.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
	Optional<Usuario> findByEmail(String email);
}
