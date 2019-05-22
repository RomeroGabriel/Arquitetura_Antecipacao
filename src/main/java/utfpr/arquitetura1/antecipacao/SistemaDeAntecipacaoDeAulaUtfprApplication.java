package utfpr.arquitetura1.antecipacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utfpr.arquitetura1.antecipacao.DAO.*;
import utfpr.arquitetura1.antecipacao.Entity.CoordinatorEntity;
import utfpr.arquitetura1.antecipacao.Entity.CourseEntity;
import utfpr.arquitetura1.antecipacao.Entity.DisciplineEntity;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SistemaDeAntecipacaoDeAulaUtfprApplication implements CommandLineRunner {

	private final StudentDAO DAO;
	private final DisciplineDAO disciplineDAO;
	private final CourseDAO courseDAO;
	private final CoordinatorDAO coordinatorDAO;
	private final FrequencyDAO frequencyDAO;

	@Autowired
	public SistemaDeAntecipacaoDeAulaUtfprApplication(StudentDAO DAO,DisciplineDAO disciplineDAO, CourseDAO courseDAO,
													  CoordinatorDAO coordinatorDAO, FrequencyDAO frequencyDAO) {
		this.DAO = DAO; this.disciplineDAO = disciplineDAO;
		this.courseDAO = courseDAO ; this.coordinatorDAO = coordinatorDAO;
		this.frequencyDAO = frequencyDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAntecipacaoDeAulaUtfprApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Stream.of(
				StudentEntity.builder().name("Gabriel Romero de Souza").RA(1828703).build(),
				StudentEntity.builder().name("Mateus Merscher").RA(1234567).build(),
				StudentEntity.builder().name("Renan Batel").RA(7654321).build()
		).forEach(DAO::save);

		/*//testing DAO
		Stream.of(
					CoordinatorEntity.builder().name("ze").build()
		).forEach(coordinatorDAO::save);
		List<CoordinatorEntity> coordList = new ArrayList<>();
		coordinatorDAO.findAll().stream().forEach(e-> coordList.add(e));

		Stream.of(
						CourseEntity.builder().name("Eng Software").coordinator(coordList.get(0)).build()
		).forEach(courseDAO::save);

		List<CourseEntity> courseList = new ArrayList<>();
		courseDAO.findAll().stream().forEach(e-> courseList.add(e));

		Stream.of(
				DisciplineEntity.builder().name("BD").course(courseList.get(0)).build()
		).forEach(disciplineDAO::save);
		long id = 1;
		StudentEntity student =new StudentEntity();

		student = DAO.findById(id).get();

		disciplineDAO.findAll().forEach(System.out::println);
		disciplineDAO.findAll().stream().forEach(e-> System.out.println((e.getName())));*/
				DAO.findAll().forEach(System.out::println);
		DAO.findAll().stream().forEach(e -> System.out.println(e.getName()));
		DAO.findAll().stream().forEach(e -> System.out.println(e.getId()));
	}
}
