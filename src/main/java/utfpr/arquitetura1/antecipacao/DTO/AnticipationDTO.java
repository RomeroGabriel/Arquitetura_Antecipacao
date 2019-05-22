package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;

@Data
@Builder
public class AnticipationDTO {

    private Long id;
    private AnticipationType type;
    // private LessonDTO lesson;
}
