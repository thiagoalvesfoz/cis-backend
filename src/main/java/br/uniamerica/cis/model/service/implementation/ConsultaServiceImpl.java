package br.uniamerica.cis.model.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uniamerica.cis.infrastructure.repository.ConsultaRepository;
import br.uniamerica.cis.infrastructure.repository.PacienteRepository;
import br.uniamerica.cis.infrastructure.repository.ProfissionalRepository;
import br.uniamerica.cis.infrastructure.repository.ServicoRepository;
import br.uniamerica.cis.model.entity.Consulta;
import br.uniamerica.cis.model.entity.enumeration.StatusConsulta;
import br.uniamerica.cis.model.exception.BusinessRuleException;
import br.uniamerica.cis.model.exception.ResourceNotFoundException;
import br.uniamerica.cis.model.service.ConsultaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
	
	private final ConsultaRepository repository;
	private final PacienteRepository pacienteRepository;
	private final ProfissionalRepository profissionalRepository;
	private final ServicoRepository servicoRepository;

	@Override
	public Consulta createConsulta(Consulta entity) {	
		
		this.valideIdsConsulta(entity);
		entity.setCreateFrom("Thiago Alves");
		entity.setCreateAt(LocalDateTime.now());
		return repository.save(entity);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Consulta> findAllConsultas() {
		return repository.findAll();
	}

	@Override
	public Consulta findConsultaById(Long id) {
		return repository.findById(id).orElseThrow( 
				() -> new ResourceNotFoundException(id) );
	}
	
	@Transactional(readOnly = true)
	private void valideIdsConsulta(Consulta entity) {
		
		var idPaciente = entity.getPaciente().getId();
		var idProfissional = entity.getProfissional().getId();
		var idConsulta = entity.getServico().getId();
		
		pacienteRepository.findById(idPaciente)
			.orElseThrow( () -> new ResourceNotFoundException(
					idPaciente + " do paciente nao encontrado"));
	
		profissionalRepository.findById(idProfissional)
			.orElseThrow( () -> new ResourceNotFoundException(
					idProfissional + " do profissional nao encontrado"));
	
		servicoRepository.findById(idConsulta)
			.orElseThrow( () -> new ResourceNotFoundException(
					idConsulta + " da consulta não encontrado"));
	}
	
	
	@Override
	public void validateStatusConsulta(String status) {
		
		if(!status.equals(StatusConsulta.AGENDADO.name())
			&& !status.equals(StatusConsulta.ATRASADO.name())
			&& !status.equals(StatusConsulta.CANCELADO.name())
			&& !status.equals(StatusConsulta.EM_ATENDIMENTO.name())
			&& !status.equals(StatusConsulta.NO_LOCAL.name())){
			
			throw new BusinessRuleException("Status de consulta inválido");
		}
			

	}

	@Override
	public Consulta updateConsulta(Long id, Consulta updated) {
		Consulta consulta = this.findConsultaById(id);
		
		if(!updated.getObservação().equals(consulta.getObservação()))
			consulta.setObservação(updated.getObservação());
		
		if(!updated.getStatus().equals(consulta.getStatus()))
			consulta.setStatus(updated.getStatus());
		
		if(!updated.getDataInicio().equals(consulta.getDataInicio()))
			consulta.setDataInicio(updated.getDataInicio());
		
		if(!updated.getDataFim().equals(consulta.getDataFim()))
			consulta.setDataFim(updated.getDataFim());
		
		consulta.setLastChange(LocalDateTime.now());
		return repository.save(consulta);
	}

	@Override
	public Consulta updateStatus(Long id, String status) {
		Consulta consulta = this.findConsultaById(id);	
		consulta.setStatus(StatusConsulta.valueOf(status));
		return repository.save(consulta);
	}
}
