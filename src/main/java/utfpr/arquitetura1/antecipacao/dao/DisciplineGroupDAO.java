package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.DisciplineGroupEntity;

public interface DisciplineGroupDAO extends JpaRepository<DisciplineGroupEntity, Long> { }
