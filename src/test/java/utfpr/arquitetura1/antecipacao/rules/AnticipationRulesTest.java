package utfpr.arquitetura1.antecipacao.rules;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utfpr.arquitetura1.antecipacao.DTO.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.exceptions.InvalidAnticipationDateException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnticipationRulesTest {

    AnticipationRules anticipationRules;

    @Before
    public void before() {
        this.anticipationRules = new AnticipationRules();
    }

    @Test (expected = InvalidAnticipationDateException.class)
    public void anticipationIsNotBeforeLesson() throws InvalidAnticipationDateException {
        

        this.anticipationRules.insert( AnticipationDTO.builder().build() );
    }
}
