package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "COURSE")
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private CoordinatorEntity coordinator;
    private String name;

}
