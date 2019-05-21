package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentEntity extends PersonEntity  implements Serializable {
    private int RA;

    @Builder
    public StudentEntity(int RA, String name, Long id){
        super(id, name);
        this.RA = RA;
    }
}
