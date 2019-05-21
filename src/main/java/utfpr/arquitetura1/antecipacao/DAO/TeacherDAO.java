package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.TeacherEntity;

public interface TeacherDAO extends JpaRepository<TeacherEntity, Long> { }
