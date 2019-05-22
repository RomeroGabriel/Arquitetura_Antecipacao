package utfpr.arquitetura1.antecipacao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utfpr.arquitetura1.antecipacao.entity.AttendanceEntity;

public interface AttendanceDAO extends JpaRepository<AttendanceEntity, Long> { }
