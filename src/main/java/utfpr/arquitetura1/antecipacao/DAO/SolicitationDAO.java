package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.SolicitationEntity;

public interface SolicitationDAO extends JpaRepository<SolicitationEntity, Long> { }
