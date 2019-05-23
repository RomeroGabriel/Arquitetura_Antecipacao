package utfpr.arquitetura1.antecipacao.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SolicitationEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String motive;
    private String lessonPlan;
    @Enumerated(EnumType.STRING)
    private SolicitationStatus status;

    /*No documento é citado que pode ser adotado um ou mais procedimento referente a reposição da aula
    Ex: Set<AnticipationEntity> antecipations */
    @OneToOne
    private AnticipationEntity anticipation;

    @OneToOne
    private ConsentListEntity consentList;
}
