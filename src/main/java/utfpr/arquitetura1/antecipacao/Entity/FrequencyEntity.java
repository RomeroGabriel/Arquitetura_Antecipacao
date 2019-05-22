package utfpr.arquitetura1.antecipacao.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
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
