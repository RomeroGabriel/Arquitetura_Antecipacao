package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.FrequencyEntity;

public interface FrequencyDAO extends JpaRepository<FrequencyEntity, Long> { }
