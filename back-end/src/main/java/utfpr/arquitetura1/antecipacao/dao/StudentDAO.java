package utfpr.arquitetura1.antecipacao.dao;

import utfpr.arquitetura1.antecipacao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentEntity, Long>{ }