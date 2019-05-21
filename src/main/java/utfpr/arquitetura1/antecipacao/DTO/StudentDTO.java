package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentDTO extends PersonDTO {
    private int RA;

    @Builder
    public StudentDTO(int RA, String name, Long id){
        super(id, name);
        this.RA = RA;
    }
}
