package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDTO {
    private long id;
    private CoordinatorDTO coordinator;
    private String name;

}
