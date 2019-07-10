package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.CourseEntity;

public interface CourseDAO extends JpaRepository<CourseEntity, Long> { }
