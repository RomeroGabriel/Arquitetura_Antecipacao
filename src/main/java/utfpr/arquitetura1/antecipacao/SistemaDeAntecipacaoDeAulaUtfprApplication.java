package utfpr.arquitetura1.antecipacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.arquitetura1.antecipacao.DAO.AnticipationDAO;
import utfpr.arquitetura1.antecipacao.DAO.StudentDAO;
import utfpr.arquitetura1.antecipacao.Entity.AnticipationEntity;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;

import java.util.stream.Stream;


@SpringBootApplication
public class SistemaDeAntecipacaoDeAulaUtfprApplication implements CommandLineRunner {

	private final AnticipationDAO DAO;

	@Autowired
	public SistemaDeAntecipacaoDeAulaUtfprApplication(AnticipationDAO DAO) {
		this.DAO = DAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAntecipacaoDeAulaUtfprApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of(
				AnticipationEntity.builder().type(AnticipationType.ONLINE).build(),
				AnticipationEntity.builder().type(AnticipationType.IN_CLASS).build(),
				AnticipationEntity.builder().type(AnticipationType.ONLINE).build()
		).forEach(DAO::save);

		DAO.findAll().forEach(System.out::println);

	}
}
