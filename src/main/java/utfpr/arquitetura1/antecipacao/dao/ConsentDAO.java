package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.ConsentEntity;

public interface ConsentDAO extends JpaRepository<ConsentEntity, Long> { }
