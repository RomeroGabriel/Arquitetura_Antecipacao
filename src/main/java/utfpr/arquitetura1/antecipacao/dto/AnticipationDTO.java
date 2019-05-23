package utfpr.arquitetura1.antecipacao.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;

@Data
@Builder
public class AnticipationDTO {

    private Long id;
    private Date date;
    private AnticipationType type;
    private LessonDTO lesson;

    /* Não deixar setar uma data de antecipação menor que a data da aula
    public void setDate(Date date) throws InvalidAnticipationDateException {
        if (this.date.compareTo(lesson.getDate()) < 0)
        throw new InvalidAnticipationDateException(date.toString());

        this.date = date;
    }
     */
}
