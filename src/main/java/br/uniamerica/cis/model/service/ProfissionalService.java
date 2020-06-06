package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Profissional;

public interface ProfissionalService {
	
	Profissional save(Profissional profissional);
	List<Profissional> findAll();
	Profissional findById(Long id);
	Profissional upgrade(Long id, Profissional entity);

}
