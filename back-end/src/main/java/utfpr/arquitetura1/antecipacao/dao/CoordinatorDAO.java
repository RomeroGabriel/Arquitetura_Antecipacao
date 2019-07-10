package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.CoordinatorEntity;

public interface CoordinatorDAO extends JpaRepository<CoordinatorEntity, Long> { }
