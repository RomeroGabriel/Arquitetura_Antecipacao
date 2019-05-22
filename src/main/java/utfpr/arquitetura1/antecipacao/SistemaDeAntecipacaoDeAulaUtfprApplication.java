package utfpr.arquitetura1.antecipacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaDeAntecipacaoDeAulaUtfprApplication implements CommandLineRunner {

	@Autowired
	public SistemaDeAntecipacaoDeAulaUtfprApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeAntecipacaoDeAulaUtfprApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}