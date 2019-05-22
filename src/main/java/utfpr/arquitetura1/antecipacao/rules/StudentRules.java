package utfpr.arquitetura1.antecipacao.rules;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import utfpr.arquitetura1.antecipacao.DAO.StudentDAO;
import utfpr.arquitetura1.antecipacao.DTO.StudentDTO;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
@NoArgsConstructor
public class StudentRules  {

    @Autowired
    private StudentDAO stuDAO;

    public void insert(StudentDTO newStudent){
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(newStudent, entity);
        stuDAO.save(entity);
    }

    public List<StudentDTO> ListStudents() {
        List<StudentDTO> AllStudents = new ArrayList<>();

        List<StudentEntity> students = stuDAO.findAll();
        BeanUtils.copyProperties(students, AllStudents);
        return AllStudents;
    }
}
