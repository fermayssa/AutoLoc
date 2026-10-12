package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Employe")
public class EmployeController {

    private final IEmployeService ie;

    @PostMapping("/addEmploye")
    public Employe addEmploye(@RequestBody Employe e) {
        return ie.addEmploye(e);
    }

    @PostMapping("/addEmployes")
    public List<Employe> addEmployes(@RequestBody List<Employe> employes) {
        return ie.addEmployes(employes);
    }

    @GetMapping("/getEmployes")
    public List<Employe> getAllEmployes() {
        return ie.retrieveAllEmployes();
    }

    @GetMapping("/getEmploye/{id}")
    public Employe getEmploye(@PathVariable("id") Long idEmploye) {
        return ie.retrieveEmploye(idEmploye);
    }

    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@RequestBody Employe e) {
        return ie.updateEmploye(e);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable("id") Long idEmploye) {
        ie.removeEmploye(idEmploye);
    }
}