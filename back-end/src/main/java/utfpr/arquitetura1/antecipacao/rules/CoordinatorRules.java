package utfpr.arquitetura1.antecipacao.rules;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import utfpr.arquitetura1.antecipacao.dao.SolicitationDAO;
import utfpr.arquitetura1.antecipacao.dto.SolicitationDTO;
import utfpr.arquitetura1.antecipacao.entity.SolicitationEntity;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;

@AllArgsConstructor
public class CoordinatorRules {

    @Autowired
    private SolicitationDAO solicitationDAO;

    public void acceptAnticipation(SolicitationDTO solicitation) {
        solicitation.setStatus(SolicitationStatus.APPROVED);
        SolicitationEntity solicitationUpdate = new SolicitationEntity();
        solicitationUpdate.setMotive(solicitation.getMotive());
        BeanUtils.copyProperties(solicitation,solicitationUpdate);
        solicitationDAO.save(solicitationUpdate);
    }
}