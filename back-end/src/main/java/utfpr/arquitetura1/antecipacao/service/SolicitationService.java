package utfpr.arquitetura1.antecipacao.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utfpr.arquitetura1.antecipacao.dto.AnticipationDTO;
import utfpr.arquitetura1.antecipacao.dto.SolicitationDTO;
import utfpr.arquitetura1.antecipacao.enums.AnticipationType;
import utfpr.arquitetura1.antecipacao.enums.SolicitationStatus;
import utfpr.arquitetura1.antecipacao.exceptions.EmptyFieldException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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

    @GetMapping("/service/anticipations")
    public ResponseEntity<List<AnticipationDTO>> listAnt (){
        return ResponseEntity.ok(anticipationList);
    }


    @PostMapping("/service/solicitation")
    public  ResponseEntity<SolicitationDTO> create (@RequestBody SolicitationDTO solicitation) {
        Optional<AnticipationDTO> anticipation =
                anticipationList.stream().filter(a -> a.getId() == solicitation.getAnticipation().getId()).findAny();

        solicitation.setId(Long.valueOf(solicitationList.size() + 1));
        solicitation.setAnticipation(anticipation.get());
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
        Optional<AnticipationDTO> anticipation =
                anticipationList.stream().filter(a -> a.getId() == solicitation.getAnticipation().getId()).findAny();

        hasSolicitation.ifPresent(s -> {
            try {
                s.setMotive(solicitation.getMotive());
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            }
            s.setStatus(solicitation.getStatus());
            s.setLessonPlan(solicitation.getLessonPlan());
            s.setAnticipation(anticipation.get());
            s.setConsentList(solicitation.getConsentList());
        });

        return ResponseEntity.of(hasSolicitation);
    }

    @GetMapping ("/service/solicitation/{id}")
    public ResponseEntity<SolicitationDTO> listById(@PathVariable Long id) {
        Optional<SolicitationDTO> hasSolicitation = solicitationList.stream().filter(s -> s.getId() == id).findAny();

        return ResponseEntity.of(hasSolicitation);
    }

    @PostMapping("/consent")
    public ResponseEntity<String> uploadConsent(@PathVariable Long id, String file) {

        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        Long Test = id;
        String base64 = file;

        System.out.println(Test);
//        solicitationList.add(solicitation);

        // Do processing with uploaded file data in Service layer

        return new ResponseEntity<String>("file uploaded", HttpStatus.OK);
    }
}
