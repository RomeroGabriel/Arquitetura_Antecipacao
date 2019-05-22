package utfpr.arquitetura1.antecipacao.rules;

import org.springframework.beans.BeanUtils;
import utfpr.arquitetura1.antecipacao.DAO.SolicitationDAO;
import utfpr.arquitetura1.antecipacao.DTO.SolicitationDTO;
import utfpr.arquitetura1.antecipacao.Entity.SolicitationEntity;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;

public class CoordinatorRules {

    private SolicitationDAO solicitationDAO;

    public void acceptAnticipation(SolicitationDTO solicitation) {
        solicitation.setStatus(SolicitationStatus.APPROVED);
        SolicitationEntity solicitationUpdate = new SolicitationEntity();
        BeanUtils.copyProperties(solicitationUpdate, solicitation);
        solicitationDAO.save(solicitationUpdate);
    }
}