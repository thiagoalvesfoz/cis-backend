package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Paciente;

public interface PacienteService {
	Paciente save(Paciente paciente);
	List<Paciente> findAll();
	Paciente findById(Long id);
	Paciente upgradePaciente(Long id, Paciente entity);
	void delete(Long id);
}
