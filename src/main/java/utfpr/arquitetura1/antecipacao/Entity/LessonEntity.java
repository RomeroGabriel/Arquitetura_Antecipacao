package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "LESSON")
public class LessonEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private DisciplineGroupEntity disciplineGroup;
    private int credits;
    @Basic @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String lessonJournal;
    @OneToMany
    private Set<AttendanceEntity> attendances;


}
