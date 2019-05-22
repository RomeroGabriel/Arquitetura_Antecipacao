package utfpr.arquitetura1.antecipacao.Entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@Entity
public class AttendanceEntity {
    @Id @GeneratedValue
    private long id;
    @ManyToOne
    private LessonEntity lesson;
    private StudentEntity student;
    private String attend;
}
