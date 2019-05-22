package utfpr.arquitetura1.antecipacao.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ATTENDANCE")
public class AttendanceEntity {
    @Id @GeneratedValue
    private long id;
    @ManyToOne
    private LessonEntity lesson;
    private StudentEntity student;
    private String attend;
}
