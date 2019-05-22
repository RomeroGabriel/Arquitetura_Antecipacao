package utfpr.arquitetura1.antecipacao.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ANTICIPATION")
public class AnticipationEntity implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private AnticipationType type;

    // @OneToOne
    // private LessonEntity lesson;
}