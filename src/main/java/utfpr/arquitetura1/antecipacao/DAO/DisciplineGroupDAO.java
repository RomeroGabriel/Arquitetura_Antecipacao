package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.DisciplineGroupEntity;

public interface DisciplineGroupDAO extends JpaRepository<DisciplineGroupEntity, Long> { }
