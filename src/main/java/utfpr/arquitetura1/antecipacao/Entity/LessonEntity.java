package utfpr.arquitetura1.antecipacao.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@Entity
public class LessonEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private DisciplineGroupEntity group;
    private int credits;
    private Date date;
    private String lessonJournal;
    @OneToMany
    private AttendanceEntity attendance;


}
