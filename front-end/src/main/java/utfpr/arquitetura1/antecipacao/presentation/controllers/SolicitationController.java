package utfpr.arquitetura1.antecipacao.presentation.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utfpr.arquitetura1.antecipacao.presentation.models.AnticipationModel;
import utfpr.arquitetura1.antecipacao.presentation.models.SolicitationModel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SolicitationController {

    static String SERVICE_BASE_URL = "http://localhost:8080";
    private AnticipationModel anticipations[] =  new AnticipationModel[0];

    private String getServiceUrl( String endpoint ) {
        return SERVICE_BASE_URL + endpoint;
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/solicitation";
    }

    @GetMapping("/solicitation")
    public String read(Model data) throws JsonSyntaxException, UnirestException {

        anticipations = new Gson()
                .fromJson(
                        Unirest
                                .get(this.getServiceUrl("/service/anticipations"))
                                .asJson()
                                .getBody()
                                .toString(),
                        AnticipationModel[].class
                );
        SolicitationModel solicitations[] = new Gson()
                .fromJson(
                        Unirest
                                .get(this.getServiceUrl("/service/solicitation"))
                                .asJson()
                                .getBody()
                                .toString(),
                        SolicitationModel[].class
                );

        data.addAttribute("solicitations", solicitations);
        data.addAttribute("anticipations", anticipations);

        return "solicitation-view";
    }


    @PostMapping ("/solicitation/create")
    public String create(SolicitationModel solicitation) throws UnirestException {

        for(int i=0;i <= anticipations.length -1;i++) {
            if(anticipations[i].getId() == solicitation.getAnticipationId())
                solicitation.setAnticipation(anticipations[i]);
        }
        Unirest.post(this.getServiceUrl("/service/solicitation"))
                .header("Content-type", "application/json")
                .header("accept", "application/json")
                .body(new Gson().toJson(solicitation, SolicitationModel.class))
                .asJson();

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
    public String edit(@RequestParam Long id, Model data) throws JsonSyntaxException, UnirestException {

        anticipations = new Gson()
                .fromJson(
                        Unirest
                                .get(this.getServiceUrl("/service/anticipations"))
                                .asJson()
                                .getBody()
                                .toString(),
                        AnticipationModel[].class
                );
        SolicitationModel solicitations[] = new Gson()
                .fromJson(
                        Unirest
                                .get(this.getServiceUrl("/service/solicitation"))
                                .asJson()
                                .getBody()
                                .toString(),
                        SolicitationModel[].class
                );

        Optional<SolicitationModel> currentSolicitationOptions = Arrays.stream(solicitations).filter(p -> p.getId() ==  id).findAny();
        SolicitationModel currentSolicitation = currentSolicitationOptions.get();

        data.addAttribute("currentSolicitation", currentSolicitation);
        data.addAttribute("anticipations", anticipations);
        data.addAttribute("solicitations", solicitations);

        return "solicitation-edit-view";
    }

    @PostMapping ("/solicitation/update")
    public String update(SolicitationModel solicitation) throws UnirestException {

        Unirest
            .put(this.getServiceUrl("/service/solicitation/{id}"))
            .routeParam("id", String.valueOf(solicitation.getId()))
            .header("Content-type", "application/json")
            .header("accept", "application/json")
            .body(new Gson().toJson(solicitation, SolicitationModel.class))
            .asJson();

        return "redirect:/solicitation";
    }

    @GetMapping("/solicitation/consents")
    public String readConsents(@RequestParam Long id, Model data) throws JsonSyntaxException, UnirestException {

        data.addAttribute("solicitation", id);

        return "solicitation-consents-view";
    }
    @PostMapping ("/solicitation/consent")
    public String uploadConsent(@RequestParam int id,MultipartFile file) throws UnirestException, IOException {

            InputStream consentS = file.getInputStream();
            byte[] bytes =  StreamUtils.copyToByteArray(consentS);
            byte[] convert = Base64.getEncoder().encode(bytes);

            Unirest
                    .post(this.getServiceUrl("/consent/{id}"))
                    .routeParam("id", String.valueOf(id))
                    .header("Content-type", "text/plain")
                    .header("accept", "application/json")
                    .body(convert);

        return "redirect:/solicitation";
    }

}