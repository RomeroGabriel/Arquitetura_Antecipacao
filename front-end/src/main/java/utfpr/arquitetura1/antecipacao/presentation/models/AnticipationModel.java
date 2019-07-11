package utfpr.arquitetura1.antecipacao.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utfpr.arquitetura1.antecipacao.presentation.enums.AnticipationType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnticipationModel {
    private Long id;
    private Date date;
    private AnticipationType type; // Nao sei se vai dar para usar enum depois
    // private LessonModel lesson;
}
