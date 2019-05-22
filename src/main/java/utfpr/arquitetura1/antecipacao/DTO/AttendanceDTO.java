package utfpr.arquitetura1.antecipacao.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendanceDTO {

    private long id;
    private LessonDTO lesson;
    private StudentDTO student;
    private String attend;


}
