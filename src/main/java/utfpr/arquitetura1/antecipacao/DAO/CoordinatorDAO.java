package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.CoordinatorEntity;

public interface CoordinatorDAO extends JpaRepository<CoordinatorEntity, Long> { }
