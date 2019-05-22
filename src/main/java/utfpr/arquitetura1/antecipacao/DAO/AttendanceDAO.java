package utfpr.arquitetura1.antecipacao.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.Entity.AttendanceEntity;

public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Long> { }
