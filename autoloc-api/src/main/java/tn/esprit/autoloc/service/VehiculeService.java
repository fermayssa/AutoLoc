package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeService implements IVehiculeService {

    VehiculeRepository vehiculeRepo;
    AgenceRepository agenceRepo;            // AJOUT
    EquipementRepository equipementRepo;    // AJOUT
    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) vehiculeRepo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepo.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        vehiculeRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return (List<Vehicule>) vehiculeRepo.saveAll(vehicules);
    }

    @Override
    @Transactional
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule v = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule introuvable : " + idVehicule));
        Agence a = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agence introuvable : " + idAgence));

        v.setAgence(a);                     // côté propriétaire (@ManyToOne)
        return vehiculeRepo.save(v);
    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule introuvable : " + idVehicule));
        Equipement eq = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Équipement introuvable : " + idEquipement));

        v.getEquipements().add(eq);         // Vehicule est le côté propriétaire (@JoinTable)
        return vehiculeRepo.save(v);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule v = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Véhicule introuvable : " + idVehicule));
        Equipement eq = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Équipement introuvable : " + idEquipement));

        boolean retire = v.getEquipements().remove(eq);   // supprime la ligne de vehicule_equipement
        if (!retire) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Cet équipement n'est pas installé sur ce véhicule.");
        }
        return vehiculeRepo.save(v);
    }
}