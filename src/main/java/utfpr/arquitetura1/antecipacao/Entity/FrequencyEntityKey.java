package utfpr.arquitetura1.antecipacao.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FrequencyEntityKey implements Serializable {
    @Column(name = "groupID")
    private Long groupID;

    @Column(name = "studentId")
    private Long studentId;

}
