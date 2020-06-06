package br.uniamerica.cis.model.service;

import java.util.List;

import br.uniamerica.cis.model.entity.Consulta;

public interface ConsultaService {

	Consulta createConsulta(Consulta entity);

	List<Consulta> findAllConsultas();

	Consulta findConsultaById(Long id);
	
	void validateStatusConsulta(String status);

	Consulta updateConsulta(Long id, Consulta entity);

	Consulta updateStatus(Long id, String status);
	

}
