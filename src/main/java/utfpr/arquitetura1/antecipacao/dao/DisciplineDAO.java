package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.DisciplineEntity;

public interface DisciplineDAO extends JpaRepository<DisciplineEntity, Long> { }