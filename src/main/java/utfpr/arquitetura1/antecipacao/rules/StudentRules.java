package utfpr.arquitetura1.antecipacao.rules;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import utfpr.arquitetura1.antecipacao.DAO.StudentDAO;
import utfpr.arquitetura1.antecipacao.DTO.StudentDTO;
import utfpr.arquitetura1.antecipacao.Entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class StudentRules {
    private StudentDAO stuDAO;

    public void insert(StudentDTO newStudent){
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(newStudent, entity);
        stuDAO.save(entity);
    }

    public List<StudentDTO> listStudents() {
        List<StudentDTO> AllStudents = new ArrayList<>();

        List<StudentEntity> students = stuDAO.findAll();
        BeanUtils.copyProperties(students, AllStudents);
        return AllStudents;
    }
}
