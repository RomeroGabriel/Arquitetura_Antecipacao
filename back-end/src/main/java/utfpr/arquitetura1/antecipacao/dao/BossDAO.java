package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.BossEntity;

public interface BossDAO extends JpaRepository<BossEntity, Long> { }