package utfpr.arquitetura1.antecipacao.rules;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utfpr.arquitetura1.antecipacao.DAO.StudentDAO;
import utfpr.arquitetura1.antecipacao.DTO.StudentDTO;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;

@Service
public class StudentRules {

    @Autowired
    private StudentDAO stuDAO;

    public void insert(StudentDTO newStudent){
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(newStudent, entity);
        stuDAO.save(entity);
    }
}
