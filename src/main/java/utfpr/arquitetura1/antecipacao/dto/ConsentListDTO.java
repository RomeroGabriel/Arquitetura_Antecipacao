package utfpr.arquitetura1.antecipacao.dto;

import lombok.Builder;
import lombok.Data;
import utfpr.arquitetura1.antecipacao.enums.ConsentListStatus;

import java.util.List;

@Data
@Builder
public class ConsentListDTO {

    private Long id;
    private ConsentListStatus status;
    private List<ConsentDTO> consents;
}
