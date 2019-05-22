package utfpr.arquitetura1.antecipacao.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FrequencyEntityKey implements Serializable {
    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "studentId")
    private Long studentId;

}
