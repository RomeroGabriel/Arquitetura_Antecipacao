package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.TeacherEntity;

public interface TeacherDAO extends JpaRepository<TeacherEntity, Long> { }
