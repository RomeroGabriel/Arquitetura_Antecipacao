package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.ConsentListEntity;

public interface ConsentListDAO extends JpaRepository<ConsentListEntity, Long> { }
