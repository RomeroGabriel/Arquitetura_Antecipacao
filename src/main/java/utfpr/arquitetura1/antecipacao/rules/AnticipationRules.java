package utfpr.arquitetura1.antecipacao.rules;

import org.springframework.beans.BeanUtils;
import utfpr.arquitetura1.antecipacao.DAO.AcademicCalendarDAO;
import utfpr.arquitetura1.antecipacao.DAO.AnticipationDAO;
import utfpr.arquitetura1.antecipacao.DTO.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.Entity.AcademicCalendarEntity;
import utfpr.arquitetura1.antecipacao.Entity.AnticipationEntity;
import utfpr.arquitetura1.antecipacao.exceptions.InvalidAnticipationDateException;

public class AnticipationRules {

    private AnticipationDAO anticipationDAO;
    AcademicCalendarDAO academicCalendarDAO;

    private Boolean anticipationDateIsBeforeLessonDate(AnticipationDTO anticipation) {

        return anticipation.getDate().compareTo(anticipation.getLesson().getDate()) < 0;
    }

    private Boolean anticipationRespectsTheAcademicCalendar(AnticipationDTO anticipation) {
        AcademicCalendarEntity academicCalendar = this.academicCalendarDAO.getOne(new Long(1));

        return anticipation.getDate().compareTo(academicCalendar.getStartDate()) > 0
            && anticipation.getDate().compareTo(academicCalendar.getFinishDate()) < 0;
    }

    public AnticipationEntity insert(AnticipationDTO anticipation) throws InvalidAnticipationDateException {
        if (!this.anticipationDateIsBeforeLessonDate(anticipation))
            throw new InvalidAnticipationDateException("The anticipation cannot be scheduled after its class");
        if (!this.anticipationRespectsTheAcademicCalendar(anticipation))
            throw new InvalidAnticipationDateException("The anticipation date must respect the academic calendar");

        AnticipationEntity entity = new AnticipationEntity();

        BeanUtils.copyProperties(anticipation, entity);

        return this.anticipationDAO.save(entity);
    }
}
