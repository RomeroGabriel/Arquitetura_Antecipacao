package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.SolicitationEntity;

public interface SolicitationDAO extends JpaRepository<SolicitationEntity, Long> { }
