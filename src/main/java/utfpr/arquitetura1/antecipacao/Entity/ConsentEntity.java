package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CONSENT")
public class ConsentEntity implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private Boolean consented;

    @OneToOne
    private StudentEntity student;
}
