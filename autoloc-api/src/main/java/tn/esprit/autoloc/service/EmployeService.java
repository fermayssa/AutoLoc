package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeService implements IEmployeService {

    EmployeRepository employeRepo;
    AgenceRepository agenceRepo;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) employeRepo.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepo.save(e);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepo.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        return (List<Employe>) employeRepo.saveAll(employes);
    }
    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe e = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employé introuvable : " + idEmploye));

        e.setAgence(null);                 // on coupe le lien, l'employé n'est pas supprimé
        return employeRepo.save(e);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe e = employeRepo.findById(idEmploye)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employé introuvable : " + idEmploye));
        Agence a = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agence introuvable : " + idAgence));

        // Règle métier : une seule agence à la fois -> désaffectation obligatoire avant un transfert
        if (e.getAgence() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "L'employé appartient déjà à l'agence " + e.getAgence().getIdAgence()
                            + " : désaffectez-le d'abord.");
        }

        e.setAgence(a);                    // côté propriétaire (@ManyToOne)
        return employeRepo.save(e);
    }
}