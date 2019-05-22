package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.LessonEntity;

public interface LessonDAO extends JpaRepository<LessonEntity, Long> { }
