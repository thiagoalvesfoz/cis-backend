package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Clinica;

public interface ClinicaService {
	Clinica save(Clinica clinica);
	List<Clinica> findAll();
	Clinica findById(Long id);
	void findClinicById(Long id);
	Clinica updateClinica(Long id, Clinica entity);
}
