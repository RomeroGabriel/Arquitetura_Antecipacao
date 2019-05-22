package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.AnticipationEntity;

public interface AnticipationDAO extends JpaRepository<AnticipationEntity, Long> { }
