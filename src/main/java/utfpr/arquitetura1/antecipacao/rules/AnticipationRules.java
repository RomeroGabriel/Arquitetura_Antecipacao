package utfpr.arquitetura1.antecipacao.rules;

import org.springframework.beans.BeanUtils;
import utfpr.arquitetura1.antecipacao.DAO.AnticipationDAO;
import utfpr.arquitetura1.antecipacao.DTO.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.Entity.AnticipationEntity;
import utfpr.arquitetura1.antecipacao.exceptions.InvalidAnticipationDateException;

public class AnticipationRules {

    private AnticipationDAO anticipationDAO;

    private Boolean anticipationDateIsBeforeLessonDate( AnticipationDTO anticipation ) {

        return anticipation.getDate().compareTo(anticipation.getLesson().getDate()) < 0;
    }

    public void insert(AnticipationDTO anticipation) throws InvalidAnticipationDateException {
        if (!this.anticipationDateIsBeforeLessonDate(anticipation))
            throw new InvalidAnticipationDateException();

        AnticipationEntity entity = new AnticipationEntity();

        BeanUtils.copyProperties(anticipation, entity);
        anticipationDAO.save(entity);
    }
}
