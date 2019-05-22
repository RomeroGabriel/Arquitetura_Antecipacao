package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.AcademicCalendarEntity;

public interface AcademicCalendarDAO extends JpaRepository<AcademicCalendarEntity, Long> { }
