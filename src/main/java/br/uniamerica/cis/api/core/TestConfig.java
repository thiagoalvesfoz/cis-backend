package br.uniamerica.cis.api.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.uniamerica.cis.domain.model.Paciente;
import br.uniamerica.cis.domain.model.Profissional;
import br.uniamerica.cis.domain.model.enumeration.StatusUsuario;
import br.uniamerica.cis.domain.repository.PacienteRepository;
import br.uniamerica.cis.domain.repository.ProfissionalRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
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
		
		Paciente u1 = new Paciente("Maria", "Brown", sdf.parse("13-03-1982"), "F", 
				"977777777", "maria@brown.com", StatusUsuario.ATIVO, "12354398723", "MariDB", null);
		
		Paciente u2 = new Paciente("Alex", "Green", sdf.parse("19-05-1980"), "M", 
				"9777888888", "alex@green.com", StatusUsuario.ATIVO, "43476387629", null, null);
		
		Paciente u3 = new Paciente("Sagan", "Santhell", sdf.parse("24-01-1990"), "M", 
				"9797979797", "sagan@santhell.com", StatusUsuario.ATIVO, "21029838299", null, null);
		
		Paciente u4 = new Paciente("Pyro", "Thingol", sdf.parse("15-10-1995"), "M", 
				"9777888888", "pyro@thingol.com", StatusUsuario.ATIVO, "54346476433", "Pyrol", null);
		
		Paciente u5 = new Paciente("Hamilton", "Santos", sdf.parse("27-03-1965"), "M", 
				"9885555558", "hamilton@santos.com", StatusUsuario.ATIVO, "232", "Milton", null);
		
		Paciente u6 = new Paciente("Eduarda", "Fernandes", sdf.parse("07-06-1997"), "F", 
				"9885444467", "eduarda@fernandes.com", StatusUsuario.ATIVO, "12354398709", "Eduardo", null);
		
		pacienteRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
	}
	
	private void profissionais() throws ParseException {
		Profissional p1 = new Profissional("Vagner", "Silva", sdf.parse("13-05-1992"), "M", 
				"977373267", "vagner@silva.com", StatusUsuario.ATIVO, 12345L);
		
		Profissional p2 = new Profissional("Milena", "Lins", sdf.parse("20-03-1994"), "F", 
				"9777888888", "milena@lins.com", StatusUsuario.ATIVO, 7775L);
		
		Profissional p3 = new Profissional("Jefferson", "Schipitoski", sdf.parse("21-08-1985"), "M", 
				"9797979797", "Jefferson@schipitoski.com", StatusUsuario.ATIVO, 2223L);
		
		Profissional p4 = new Profissional("Brandow", "Buenos", sdf.parse("11-11-1991"), "M", 
				"9745288823", "brandowbuenos@hotmail.com", StatusUsuario.ATIVO, 32115L);
		
		Profissional p5 = new Profissional("William", "Will", sdf.parse("12-06-1989"), "M", 
				"9885231558", "will_william@yahoo.com.br", StatusUsuario.ATIVO, 988375L);
		
		Profissional p6 = new Profissional("Luisa", "Mara", sdf.parse("18-11-1996"), "F", 
				"98854433334", "luisamara96@hotmail.com", StatusUsuario.ATIVO, 122225L);
		
		pRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
