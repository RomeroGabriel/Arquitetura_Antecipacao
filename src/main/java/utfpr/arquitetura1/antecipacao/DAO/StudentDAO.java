package utfpr.arquitetura1.antecipacao.DAO;

import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentEntity, Long>{ }
