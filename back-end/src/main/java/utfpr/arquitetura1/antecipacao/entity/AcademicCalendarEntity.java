package utfpr.arquitetura1.antecipacao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AcademicCalendarEntity implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private Integer semester;
    @Basic @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
}