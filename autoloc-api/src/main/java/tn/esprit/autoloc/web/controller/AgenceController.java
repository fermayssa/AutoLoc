package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Agence")
public class AgenceController {

    private final IAgenceService ia;

    @PostMapping("/addAgence")
    public Agence addAgence(@RequestBody Agence a) {
        return ia.addAgence(a);
    }

    @PostMapping("/addAgences")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return ia.addAgences(agences);
    }

    @GetMapping("/getAgences")
    public List<Agence> getAllAgences() {
        return ia.retrieveAllAgences();
    }

    @GetMapping("/getAgence/{id}")
    public Agence getAgence(@PathVariable("id") Long idAgence) {
        return ia.retrieveAgence(idAgence);
    }

    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence a) {
        return ia.updateAgence(a);
    }

    @DeleteMapping("/deleteAgence/{id}")
    public void deleteAgence(@PathVariable("id") Long idAgence) {
        ia.removeAgence(idAgence);
    }
}