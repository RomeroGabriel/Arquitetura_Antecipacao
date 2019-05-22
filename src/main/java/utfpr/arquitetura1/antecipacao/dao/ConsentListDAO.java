package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.ConsentListEntity;

public interface ConsentListDAO extends JpaRepository<ConsentListEntity, Long> { }
