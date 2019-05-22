package utfpr.arquitetura1.antecipacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.arquitetura1.antecipacao.DAO.StudentDAO;
import utfpr.arquitetura1.antecipacao.DTO.StudentDTO;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;
import utfpr.arquitetura1.antecipacao.rules.StudentRules;

import java.util.stream.Stream;


@SpringBootApplication
public class SistemaDeAntecipacaoDeAulaUtfprApplication implements CommandLineRunner {

	private final StudentDAO DAO;

	@Autowired
	public SistemaDeAntecipacaoDeAulaUtfprApplication(StudentDAO DAO) {
		this.DAO = DAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAntecipacaoDeAulaUtfprApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StudentRules rules = new StudentRules(DAO);
		Stream.of(
				StudentEntity.builder().name("Gabriel Romero de Souza").RA(1828703).build(),
				StudentEntity.builder().name("Mateus Merscher").RA(1234567).build(),
				StudentEntity.builder().name("Renan Batel").RA(7654321).build()
		).forEach(DAO::save);

		Stream.of(
				StudentDTO.builder().name("Gabriel Romero de Souza").RA(1828703).build(),
				StudentDTO.builder().name("Mateus Merscher").RA(1234567).build(),
				StudentDTO.builder().name("Renan Batel").RA(7654321).build()
		).forEach(el -> rules.insert(el));

		DAO.findAll().forEach(System.out::println);
		DAO.findAll().stream().forEach(e -> System.out.println(e.getName()));
		DAO.findAll().stream().forEach(e -> System.out.println(e.getId()));
		rules.listStudents().stream().forEach(System.out::println);
	}
}
