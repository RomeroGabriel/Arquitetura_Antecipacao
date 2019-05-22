package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;

@Data
@Builder
public class SolicitationDTO {

    private Long id;
    private String motive;
    private String lessonPlan;
    private SolicitationStatus status;
    private AnticipationDTO anticipation;
    private ConsentListDTO consentList;
}
