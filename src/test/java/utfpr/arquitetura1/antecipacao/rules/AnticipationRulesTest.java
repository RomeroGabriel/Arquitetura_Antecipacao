package utfpr.arquitetura1.antecipacao.rules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utfpr.arquitetura1.antecipacao.DAO.AcademicCalendarDAO;
import utfpr.arquitetura1.antecipacao.DTO.AcademicCalendarDTO;
import utfpr.arquitetura1.antecipacao.DTO.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.DTO.LessonDTO;
import utfpr.arquitetura1.antecipacao.Entity.AcademicCalendarEntity;
import utfpr.arquitetura1.antecipacao.exceptions.InvalidAnticipationDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnticipationRulesTest {

    AnticipationRules anticipationRules;
    @Autowired
    AcademicCalendarDAO academicCalendarDAO;

    @Before
    public void before() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        this.anticipationRules = new AnticipationRules();
        this.academicCalendarDAO.save(
                AcademicCalendarEntity
                        .builder()
                        .startDate(format.parse("02/03/2019 00:00:00"))
                        .finishDate(format.parse("07/07/2019 00:00:00"))
                        .semester(1)
                        .build()
        );
    }

    @Test (expected = InvalidAnticipationDateException.class)
    public void anticipationIsNotBeforeLesson() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        LessonDTO lesson = LessonDTO
                .builder()
                .date(format.parse("22/05/2019 16:00:00"))
                .build();
        AnticipationDTO anticipation = AnticipationDTO
                .builder()
                .date(format.parse("23/05/2019 16:00:00"))
                .lesson(lesson)
                .build();

        try {
            this.anticipationRules.insert(anticipation);
        } catch (InvalidAnticipationDateException e) {
            Assert.assertEquals("The anticipation cannot be scheduled after its class", e.getMessage());
        }
    }

}
