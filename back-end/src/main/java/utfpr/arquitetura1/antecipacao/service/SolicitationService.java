package utfpr.arquitetura1.antecipacao.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utfpr.arquitetura1.antecipacao.dto.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.dto.SolicitationDTO;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class SolicitationService {

    private List<AnticipationDTO> anticipationList;
    private List<SolicitationDTO> solicitationList;

    public SolicitationService () {

        anticipationList = Stream.of(
                AnticipationDTO.builder().id(1L).type(AnticipationType.ONLINE).build(),
                AnticipationDTO.builder().id(2L).type(AnticipationType.IN_CLASS).build()
        ).collect(Collectors.toList());

        solicitationList = Stream.of(
            SolicitationDTO.builder().id(1L).anticipation(anticipationList.stream().findFirst().get())
                    .lessonPlan("Aulas de intradução a padrões de projeto")
                    .motive("Viajem do professor")
                    .status(SolicitationStatus.APPROVED).build(),
            SolicitationDTO.builder().id(2L).anticipation(anticipationList.stream().findFirst().get())
                    .lessonPlan("Aulas de Spring Boot")
                    .motive("Motivos pessoais do professor")
                    .status(SolicitationStatus.APPROVED).build()
        ).collect(Collectors.toList());
    }

    @GetMapping("/service/solicitation")
    public ResponseEntity<List<SolicitationDTO>> list (){
        return ResponseEntity.ok(solicitationList);
    }

    @PostMapping("/service/solicitation")
    public  ResponseEntity<SolicitationDTO> create (@RequestBody SolicitationDTO solicitation) {
        solicitation.setId(Long.valueOf(solicitationList.size() + 1));
        solicitationList.add(solicitation);
        return ResponseEntity.status(201).body(solicitation);
    }

    @DeleteMapping("/service/solicitation/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        if(solicitationList.removeIf(s -> s.getId() == id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/service/solicitation/{id}")
    public ResponseEntity<SolicitationDTO> update (@PathVariable Long id, @RequestBody SolicitationDTO solicitation){
        Optional<SolicitationDTO> hasSolicitation = solicitationList.stream().filter(s -> s.getId() == id).findAny();

        hasSolicitation.ifPresent(s -> {
            try {
                s.setMotive(solicitation.getMotive());
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            }
            s.setStatus(solicitation.getStatus());
            s.setLessonPlan(solicitation.getLessonPlan());
            s.setAnticipation(solicitation.getAnticipation());
            s.setConsentList(solicitation.getConsentList());
        });

        return ResponseEntity.of(hasSolicitation);
    }

    @GetMapping ("/service/solicitation/{id}")
    public ResponseEntity<SolicitationDTO> listById(@PathVariable Long id) {
        Optional<SolicitationDTO> hasSolicitation = solicitationList.stream().filter(s -> s.getId() == id).findAny();

        return ResponseEntity.of(hasSolicitation);
    }
}
