package utfpr.arquitetura1.antecipacao.rules;

import org.springframework.beans.BeanUtils;
import utfpr.arquitetura1.antecipacao.dao.AcademicCalendarDAO;
import utfpr.arquitetura1.antecipacao.dao.AnticipationDAO;
import utfpr.arquitetura1.antecipacao.dto.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.entity.AcademicCalendarEntity;
import utfpr.arquitetura1.antecipacao.entity.AnticipationEntity;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;
import utfpr.arquitetura1.antecipacao.exceptions.InvalidAnticipationDateException;

public class AnticipationRules {

    private AnticipationDAO anticipationDAO;
    private AcademicCalendarDAO academicCalendarDAO;

    /*
        Adicionar injeção de dependencia para os daos acima, para que eles sejam
        inicializados e ser usados nos métodos abaixo sem precisar passar o dao
        como parametro dos métodos
     */
    private Boolean anticipationDateIsBeforeLessonDate(AnticipationDTO anticipation) {

        return anticipation.getDate().compareTo(anticipation.getLesson().getDate()) < 0;
    }

    private Boolean anticipationRespectsTheAcademicCalendar(AnticipationDTO anticipation) {
        AcademicCalendarEntity academicCalendar = this.academicCalendarDAO.getOne(new Long(1));

        return anticipation.getDate().compareTo(academicCalendar.getStartDate()) > 0
                && anticipation.getDate().compareTo(academicCalendar.getFinishDate()) < 0;
    }

    private Boolean anticipationDontHaveLesson(AnticipationDTO anticipation) {

        return anticipation.getLesson() == null;
    }

    public AnticipationEntity insert(AnticipationDTO anticipation) throws InvalidAnticipationDateException, EmptyFieldException {
        if (this.anticipationDontHaveLesson(anticipation)) {
            throw new EmptyFieldException("Anticipation lesson");
        }
        if (!this.anticipationDateIsBeforeLessonDate(anticipation)) {
            throw new InvalidAnticipationDateException("The anticipation cannot be scheduled after its class");
        }
        if (!this.anticipationRespectsTheAcademicCalendar(anticipation)) {
            throw new InvalidAnticipationDateException("The anticipation date must respect the academic calendar");
        }

        AnticipationEntity entity = new AnticipationEntity();

        BeanUtils.copyProperties(anticipation, entity);

        return this.anticipationDAO.save(entity);
    }
}
