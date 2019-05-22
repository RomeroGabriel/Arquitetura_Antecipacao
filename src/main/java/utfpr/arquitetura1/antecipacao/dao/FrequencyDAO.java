package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.FrequencyEntity;

public interface FrequencyDAO extends JpaRepository<FrequencyEntity, Long> { }
