package br.uniamerica.cis.api.core;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.uniamerica.cis.domain.model.Endereco;
import br.uniamerica.cis.domain.model.Paciente;
import br.uniamerica.cis.domain.model.Profissional;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.PacienteRepository;
import br.uniamerica.cis.domain.repository.ProfissionalRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProfissionalRepository pRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public void run(String...args) {
		try {
			pacientes();
			profissionais();
		}catch(ParseException ex) {
			ex.printStackTrace();
		}
	}
	
	private void pacientes() throws ParseException {

		Paciente u1 = new Paciente("Maria", "Brown", LocalDate.parse("1982-03-13"), "F", 
				"977777777", "maria@brown.com", StatusUsuario.ATIVO, "12354398723", "MariDB", null);
		
		Paciente u2 = new Paciente("Alex", "Green", LocalDate.parse("1980-05-19"), "M", 
				"9777888888", "alex@green.com", StatusUsuario.ATIVO, "43476387629", null, null);
		
		Paciente u3 = new Paciente("Sagan", "Santhell", LocalDate.parse("1990-01-24"), "M", 
				"9797979797", "sagan@santhell.com", StatusUsuario.ATIVO, "21029838299", null, null);
		
		Paciente u4 = new Paciente("Pyro", "Thingol", LocalDate.parse("1995-10-15"), "M", 
				"9777888888", "pyro@thingol.com", StatusUsuario.ATIVO, "54346476433", "Pyrol", null);
		
		Paciente u5 = new Paciente("Hamilton", "Santos", LocalDate.parse("1965-03-27"), "M", 
				"9885555558", "hamilton@santos.com", StatusUsuario.ATIVO, "232", "Milton", null);
		
		Paciente u6 = new Paciente("Eduarda", "Fernandes", LocalDate.parse("1997-06-07"), "F", 
				"9885444467", "eduarda@fernandes.com", StatusUsuario.ATIVO, "12354398709", "Eduardo", null);
		
		
		pacienteRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		
		//Adicionando endereco
		Endereco e1 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u1);
		Endereco e2 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u2);
		Endereco e3 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u3);
		Endereco e4 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u4);
		Endereco e5 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u5);
		Endereco e6 = new Endereco(null, "85854-400", 70L, "Rua Balduíno Weirich, Vila Boa Esperança", u6);
		
		u1.setEndereco(e1);
		u2.setEndereco(e2);
		u3.setEndereco(e3);
		u4.setEndereco(e4);
		u5.setEndereco(e5);
		u6.setEndereco(e6);
		
		pacienteRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
	}
	
	private void profissionais() throws ParseException {
		Profissional p1 = new Profissional("Vagner", "Silva", LocalDate.parse("1992-05-13"), "M", 
				"977373267", "vagner@silva.com", StatusUsuario.ATIVO, 12345L);
		
		Profissional p2 = new Profissional("Milena", "Lins", LocalDate.parse("1994-03-20"), "F", 
				"9777888888", "milena@lins.com", StatusUsuario.ATIVO, 7775L);
		
		Profissional p3 = new Profissional("Jefferson", "Schipitoski", LocalDate.parse("1985-08-15"), "M", 
				"9797979797", "Jefferson@schipitoski.com", StatusUsuario.ATIVO, 2223L);
		
		Profissional p4 = new Profissional("Brandow", "Buenos", LocalDate.parse("1991-11-03"), "M", 
				"9745288823", "brandowbuenos@hotmail.com", StatusUsuario.ATIVO, 32115L);
		
		Profissional p5 = new Profissional("William", "Will", LocalDate.parse("1989-06-12"), "M", 
				"9885231558", "will_william@yahoo.com.br", StatusUsuario.ATIVO, 988375L);
		
		Profissional p6 = new Profissional("Luisa", "Mara", LocalDate.parse("1996-11-18"), "F", 
				"98854433334", "luisamara96@hotmail.com", StatusUsuario.ATIVO, 122225L);
		
		pRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
