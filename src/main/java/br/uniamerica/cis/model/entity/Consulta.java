package br.uniamerica.cis.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.uniamerica.cis.model.entity.enumeration.StatusConsulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime dataInicio;
	
	@Column(nullable = false)
	private LocalDateTime dataFim;
	
	private String observação;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusConsulta status;
	
	@Column(nullable = true)
	private String createFrom;
	
	//@CreationTimestamp     -> utilizar
	@Column(nullable = true)
	private LocalDateTime createAt;
	private LocalDateTime lastChange;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	public Consulta(Paciente paciente, Profissional profissional, Servico servico) {
		this.paciente = paciente;
		this.profissional = profissional;
		this.servico = servico;
	}
	
	

}
