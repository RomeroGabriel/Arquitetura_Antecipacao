package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.ConsentEntity;

public interface ConsentDAO extends JpaRepository<ConsentEntity, Long> { }
