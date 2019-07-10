package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.AcademicCalendarEntity;

public interface AcademicCalendarDAO extends JpaRepository<AcademicCalendarEntity, Long> { }
