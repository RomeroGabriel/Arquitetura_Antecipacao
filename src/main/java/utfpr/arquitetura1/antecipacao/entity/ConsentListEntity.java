package utfpr.arquitetura1.antecipacao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.enums.ConsentListStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ConsentListEntity implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private ConsentListStatus status;

    @OneToMany
    private Set<ConsentEntity> consents;
}
