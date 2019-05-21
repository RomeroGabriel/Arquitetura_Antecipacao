package utfpr.arquitetura1.antecipacao.Entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class PersonEntity implements Serializable {
    @Id @GeneratedValue
    private Long Id;
    private String name;
}
