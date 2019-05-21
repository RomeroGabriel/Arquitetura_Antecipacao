package utfpr.arquitetura1.antecipacao.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PersonDTO {
    private Long id;
    private String nome;
}