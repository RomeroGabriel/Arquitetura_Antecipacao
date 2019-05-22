package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;

import java.util.Date;

@Data
@Builder
public class AnticipationDTO {

    private Long id;
    private Date date;
    private AnticipationType type;
    private LessonDTO lesson;
}
