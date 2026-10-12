package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Equipement")
public class EquipementController {

    private final IEquipementService ie;

    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement e) {
        return ie.addEquipement(e);
    }

    @PostMapping("/addEquipements")
    public List<Equipement> addEquipements(@RequestBody List<Equipement> equipements) {
        return ie.addEquipements(equipements);
    }

    @GetMapping("/getEquipements")
    public List<Equipement> getAllEquipements() {
        return ie.retrieveAllEquipements();
    }

    @GetMapping("/getEquipement/{id}")
    public Equipement getEquipement(@PathVariable("id") Long idEquipement) {
        return ie.retrieveEquipement(idEquipement);
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement e) {
        return ie.updateEquipement(e);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable("id") Long idEquipement) {
        ie.removeEquipement(idEquipement);
    }
}