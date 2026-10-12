package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Paiement")
public class PaiementController {

    private final IPaiementService ip;

    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement p) {
        return ip.addPaiement(p);
    }

    @PostMapping("/addPaiements")
    public List<Paiement> addPaiements(@RequestBody List<Paiement> paiements) {
        return ip.addPaiements(paiements);
    }

    @GetMapping("/getPaiements")
    public List<Paiement> getAllPaiements() {
        return ip.retrieveAllPaiements();
    }

    @GetMapping("/getPaiement/{id}")
    public Paiement getPaiement(@PathVariable("id") Long idPaiement) {
        return ip.retrievePaiement(idPaiement);
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement p) {
        return ip.updatePaiement(p);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void deletePaiement(@PathVariable("id") Long idPaiement) {
        ip.removePaiement(idPaiement);
    }
}