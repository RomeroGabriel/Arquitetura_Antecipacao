package utfpr.arquitetura1.antecipacao.rules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import utfpr.arquitetura1.antecipacao.DTO.SolicitationDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoordinatorRulesTest {

    private CoordinatorRules coordinatorRules;

    @Before
    public void before() {
        this.coordinatorRules = new CoordinatorRules();
    }

    @Test
    public void coordinatorAcceptAnticipation(){
        SolicitationDTO soli = SolicitationDTO.builder().motive("Test").build();
        coordinatorRules.acceptAnticipation(soli);
        Assert.assertTrue(soli.getStatus().toString() == "APPROVED");
    }
}
