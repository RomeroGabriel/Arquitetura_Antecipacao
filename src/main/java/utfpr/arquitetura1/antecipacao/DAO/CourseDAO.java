package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.CourseEntity;

public interface CourseDAO extends JpaRepository<CourseEntity, Long> { }
