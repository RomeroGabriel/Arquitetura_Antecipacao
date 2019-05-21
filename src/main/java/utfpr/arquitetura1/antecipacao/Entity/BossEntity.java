package utfpr.arquitetura1.antecipacao.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@Entity
public class BossEntity extends PersonEntity implements Serializable { }
