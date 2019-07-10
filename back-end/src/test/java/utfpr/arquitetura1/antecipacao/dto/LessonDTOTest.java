package utfpr.arquitetura1.antecipacao.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LessonDTOTest {

    @Test (expected = EmptyFieldException.class)
    public void setJournalTest() throws EmptyFieldException {
        LessonDTO.builder().build().setLessonJournal("");
    }
}
