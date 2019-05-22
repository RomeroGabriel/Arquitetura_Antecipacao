package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentEntity extends PersonEntity  implements Serializable {
    private int RA;
    @OneToMany(mappedBy = "Group")
    private Set<FrequencyEntity> frequencies;

    @Builder
    public StudentEntity(int RA, String name, Long id){
        super(id, name);
        this.RA = RA;
    }
}
