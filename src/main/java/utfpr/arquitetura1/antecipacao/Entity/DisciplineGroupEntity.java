package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "DISCIPLINE_GROUP")
public class DisciplineGroupEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private TeacherEntity teacher;
    @ManyToOne
    private DisciplineEntity discipline;
    @OneToMany(mappedBy = "disciplineGroup")
    private Set<FrequencyEntity> frequencies;


}
