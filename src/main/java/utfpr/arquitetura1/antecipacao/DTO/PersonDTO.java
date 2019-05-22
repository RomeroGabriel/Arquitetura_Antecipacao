package utfpr.arquitetura1.antecipacao.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonDTO {
    private Long id;
    private String name;
}