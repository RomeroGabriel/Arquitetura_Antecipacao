package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;

@Data
@Builder
public class SolicitationDTO {

    private Long id;
    private String motive;
    private String lessonPlan;
    private SolicitationStatus status;
    private AnticipationDTO anticipation;
    private ConsentListDTO consentList;

    public void setMotive(String motive) throws EmptyFieldException {
        if (motive.isEmpty())
            throw new EmptyFieldException("Solicitation motive");

        this.motive = motive;
    }
}
