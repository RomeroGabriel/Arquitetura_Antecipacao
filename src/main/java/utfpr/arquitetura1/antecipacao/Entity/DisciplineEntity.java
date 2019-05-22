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
public class DisciplineEntity  implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private CourseEntity course;

}
