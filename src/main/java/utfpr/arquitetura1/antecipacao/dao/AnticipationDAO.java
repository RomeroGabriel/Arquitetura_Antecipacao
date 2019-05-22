package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.AnticipationEntity;

public interface AnticipationDAO extends JpaRepository<AnticipationEntity, Long> { }
