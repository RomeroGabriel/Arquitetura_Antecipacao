package utfpr.arquitetura1.antecipacao.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsentDTO {

    private Long id;
    private Boolean consented;
    private StudentDTO student;
}
