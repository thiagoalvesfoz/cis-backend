package br.uniamerica.cis.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uniamerica.cis.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long > {
	
	Optional<Usuario> findByEmail(String email);
}
