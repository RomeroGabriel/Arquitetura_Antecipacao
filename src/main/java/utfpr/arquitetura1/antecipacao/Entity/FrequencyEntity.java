package utfpr.arquitetura1.antecipacao.Entity;


import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

public class FrequencyEntity implements Serializable {
    @EmbeddedId
    FrequencyEntityKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    StudentEntity student;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "groupId")
    DisciplineGroupEntity group;

    private float frequency;


}
