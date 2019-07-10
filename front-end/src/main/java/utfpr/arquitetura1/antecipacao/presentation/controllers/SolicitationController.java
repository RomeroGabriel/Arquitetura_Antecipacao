package utfpr.arquitetura1.antecipacao.presentation.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utfpr.arquitetura1.antecipacao.apresentacao.PaisModel;
import utfpr.arquitetura1.antecipacao.presentation.models.SolicitationModel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SolicitationController {

    static String SERVICE_BASE_URL = "http://localhost:8080/";

    private String getServiceUrl( String endpoint ) {
        return SERVICE_BASE_URL + endpoint;
    }

    @GetMapping("/solicitation")
    public String read(Model data) throws JsonSyntaxException, UnirestException {

//        SolicitationModel solicitations[] = new Gson()
//                    .fromJson(
//                        Unirest
//                            .get(this.getServiceUrl("[endpoint]"))
//                            .asJson()
//                            .getBody()
//                            .toString(),
//                        SolicitationModel[].class
//                    );

        List<SolicitationModel> solicitations = Stream.of(
                SolicitationModel.builder().id(new Long(1)).motive("motive 1").lessonPlan("plan 1").solicitationStatus("status 1").anticipationId(new Long(1)).build()
        ).collect(Collectors.toList());

        data.addAttribute("solicitations", solicitations);

        return "solicitation-view";
    }

    @PostMapping ("/solicitation/create")
    public String create(SolicitationModel solicitation) throws UnirestException {

//            Unirest.post(this.getServiceUrl("[endpoint]"))
//                .header("Content-type", "application/json")
//                .header("accept", "application/json")
//                .body(new Gson().toJson(solicitation, SolicitationModel.class))
//                .asJson();

        return "redirect:/solicitation";
    }

    @GetMapping ("/solicitation/delete")
    public String delete(@RequestParam int id) throws UnirestException {

//        Unirest
//            .delete(this.getServiceUrl("[endpoint]"))
//            .routeParam("id", String.valueOf(id))
//            .asJson();

        return "redirect:/solicitation";
    }

    @GetMapping ("/solicitation/edit")
    public String edit(@RequestParam int id, Model data) throws JsonSyntaxException, UnirestException {

//        SolicitationModel currentSolicitation = new Gson()
//            .fromJson(
//                Unirest
//                    .get(this.getServiceUrl("[endpoint]"))
//                    .routeParam("id", String.valueOf(id))
//                    .asJson()
//                    .getBody()
//                    .toString(),
//                SolicitationModel.class
//            );

        SolicitationModel currentSolicitation = SolicitationModel.builder().id(new Long(1)).motive("motive 1").lessonPlan("plan 1").solicitationStatus("status 1").anticipationId(new Long(1)).build();

        data.addAttribute("currentSolicitation", currentSolicitation);

//        SolicitationModel solicitations[] = new Gson()
////                    .fromJson(
////                        Unirest
////                            .get(this.getServiceUrl("[endpoint]"))
////                            .asJson()
////                            .getBody()
////                            .toString(),
////                        SolicitationModel[].class
////                    );

        List<SolicitationModel> solicitations = Stream.of(
                SolicitationModel.builder().id(new Long(1)).motive("motive 1").lessonPlan("plan 1").solicitationStatus("status 1").anticipationId(new Long(1)).build()
        ).collect(Collectors.toList());

        data.addAttribute("solicitations", solicitations);

        return "solicitation-edit-view";
    }

    @PostMapping ("/solicitation/update")
    public String update(SolicitationModel solicitation) throws UnirestException {

//        Unirest
//            .put(this.getServiceUrl("[endpoint]"))
//            .routeParam("id", String.valueOf(solicitation.getId()))
//            .header("Content-type", "application/json")
//            .header("accept", "application/json")
//            .body(new Gson().toJson(solicitation, SolicitationModel.class))
//            .asJson();

        return "redirect:/solicitation";
    }

    @GetMapping("/solicitation/consents")
    public String readConsents(Model data) throws JsonSyntaxException, UnirestException {

        return "solicitation-consents-view";
    }
}