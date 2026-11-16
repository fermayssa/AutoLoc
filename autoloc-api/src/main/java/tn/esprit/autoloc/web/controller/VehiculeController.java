package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Vehicule")
public class VehiculeController {

    private final IVehiculeService iv;

    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return iv.addVehicule(v);
    }

    @PostMapping("/addVehicules")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
        return iv.addVehicules(vehicules);
    }

    @GetMapping("/getVehicules")
    public List<Vehicule> getAllVehicules() {
        return iv.retrieveAllVehicules();
    }

    @GetMapping("/getVehicule/{id}")
    public Vehicule getVehicule(@PathVariable("id") Long idVehicule) {
        return iv.retrieveVehicule(idVehicule);
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule v) {
        return iv.updateVehicule(v);
    }

    @DeleteMapping("/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable("id") Long idVehicule) {
        iv.removeVehicule(idVehicule);
    }
    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable("idVehicule") Long idVehicule,
                                     @PathVariable("idAgence") Long idAgence) {
        return iv.affecterVehicule(idVehicule, idAgence);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable("idVehicule") Long idVehicule,
                                       @PathVariable("idEquipement") Long idEquipement) {
        return iv.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable("idVehicule") Long idVehicule,
                                          @PathVariable("idEquipement") Long idEquipement) {
        return iv.desaffecterEquipement(idVehicule, idEquipement);
    }



    // Q1
    @GetMapping("/marque/{marque}")
    public List<Vehicule> getByMarque(@PathVariable String marque) {
        return vehiculeService.getVehiculesByMarque(marque);
    }

    // Q2
    @GetMapping("/categorie/{categorie}")
    public List<Vehicule> getByCategorie(@PathVariable CategorieVehicule categorie) {
        return vehiculeService.getVehiculesByCategorie(categorie);
    }

    // Q3
    @GetMapping("/disponibles")
    public List<Vehicule> getDisponibles() {
        return vehiculeService.getVehiculesDisponibles();
    }

    // Q5
    @GetMapping("/search")
    public List<Vehicule> searchByMarque(@RequestParam String marque) {
        return vehiculeService.searchVehiculesByMarque(marque);
    }

    // Q8
    @GetMapping("/tarif-superieur")
    public List<Vehicule> getTarifSuperieur(@RequestParam(defaultValue = "100") BigDecimal tarif) {
        return vehiculeService.getVehiculesTarifSuperieurA(tarif);
    }

    // Q11
    @GetMapping("/marque-statut")
    public List<Vehicule> getByMarqueAndStatut(@RequestParam String marque,
                                               @RequestParam StatutVehicule statut) {
        return vehiculeService.getVehiculesByMarqueEtStatut(marque, statut);
    }
}