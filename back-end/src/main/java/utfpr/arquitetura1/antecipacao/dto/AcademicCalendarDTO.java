package utfpr.arquitetura1.antecipacao.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AcademicCalendarDTO {

    private Long id;
    private Integer semester;
    private Date startDate;
    private Date finishDate;
}
