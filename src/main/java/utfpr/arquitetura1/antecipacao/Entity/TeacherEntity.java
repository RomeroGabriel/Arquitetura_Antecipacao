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
@Entity(name = "TEACHER")
public class TeacherEntity extends PersonEntity implements Serializable {

    @Builder
    public TeacherEntity(String name, Long id, BossEntity boss){
        super(id, name);
        this.boss = boss;
    }

    @ManyToOne
    private BossEntity boss;
}
