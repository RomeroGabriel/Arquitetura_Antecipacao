package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;

import javax.persistence.*;
import java.io.Serializable;

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

    @OneToOne
    private AnticipationEntity anticipation;

    @OneToOne
    private ConsentListEntity consentList;
}