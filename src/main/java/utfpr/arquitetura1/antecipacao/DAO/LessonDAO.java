package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.LessonEntity;

public interface LessonDAO extends JpaRepository<LessonEntity, Long> { }
