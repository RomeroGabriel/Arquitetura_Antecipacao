package utfpr.arquitetura1.antecipacao.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "COORDINATOR")
public class CoordinatorEntity extends PersonEntity implements Serializable {
    @Builder
    public CoordinatorEntity(String name, Long id){
        super(id, name);
    }
}
