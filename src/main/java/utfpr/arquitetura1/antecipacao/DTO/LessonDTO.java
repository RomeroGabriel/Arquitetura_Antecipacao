package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class LessonDTO {
    private long id;
    private DisciplineGroupEntityDTO disciplineGroup;
    private int credits;
    private Date date;
    private String lessonJournal;

}
