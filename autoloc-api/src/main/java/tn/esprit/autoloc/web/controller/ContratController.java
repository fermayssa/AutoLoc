package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Contrat")
public class ContratController {

    private final IContratService ic;

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        return ic.addContrat(c);
    }

    @PostMapping("/addContrats")
    public List<Contrat> addContrats(@RequestBody List<Contrat> contrats) {
        return ic.addContrats(contrats);
    }

    @GetMapping("/getContrats")
    public List<Contrat> getAllContrats() {
        return ic.retrieveAllContrats();
    }

    @GetMapping("/getContrat/{id}")
    public Contrat getContrat(@PathVariable("id") Long idContrat) {
        return ic.retrieveContrat(idContrat);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return ic.updateContrat(c);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") Long idContrat) {
        ic.removeContrat(idContrat);
    }
}