package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

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
}