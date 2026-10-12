package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Maintenance")
public class MaintenanceController {

    private final IMaintenanceService im;

    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance m) {
        return im.addMaintenance(m);
    }

    @PostMapping("/addMaintenances")
    public List<Maintenance> addMaintenances(@RequestBody List<Maintenance> maintenances) {
        return im.addMaintenances(maintenances);
    }

    @GetMapping("/getMaintenances")
    public List<Maintenance> getAllMaintenances() {
        return im.retrieveAllMaintenances();
    }

    @GetMapping("/getMaintenance/{id}")
    public Maintenance getMaintenance(@PathVariable("id") Long idMaintenance) {
        return im.retrieveMaintenance(idMaintenance);
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance m) {
        return im.updateMaintenance(m);
    }

    @DeleteMapping("/deleteMaintenance/{id}")
    public void deleteMaintenance(@PathVariable("id") Long idMaintenance) {
        im.removeMaintenance(idMaintenance);
    }
}