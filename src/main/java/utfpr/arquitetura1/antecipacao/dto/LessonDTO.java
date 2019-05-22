package utfpr.arquitetura1.antecipacao.dto;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class LessonDTO {
    private long id;
    private DisciplineGroupEntityDTO disciplineGroup;
    private int credits;
    private Date date;
    private String lessonJournal;
    private Set<AttendanceDTO> attendances;

    public void setLessonJournal(String journal) throws EmptyFieldException {
        if (journal.isEmpty())
            throw new EmptyFieldException("Solicitation lesson Journal");

        this.lessonJournal = journal;
    }

}
