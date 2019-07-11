package utfpr.arquitetura1.antecipacao.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.presentation.enums.SolicitationStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitationModel {
    private Long id;
    private String motive;
    private String lessonPlan;
    // private SolicitationStatus solicitationStatus; Nao sei se vai dar para usar enum depois
    private String solicitationStatus;
    private AnticipationModel anticipation;
    private Long anticipationId;
}
