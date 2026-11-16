package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule(Vehicule v);
    Vehicule updateVehicule(Vehicule v);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List<Vehicule> addVehicules(List<Vehicule> vehicules);
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    List<Vehicule> getVehiculesByMarque(String marque);                       // Q1
    List<Vehicule> getVehiculesByCategorie(CategorieVehicule categorie);      // Q2
    List<Vehicule> getVehiculesDisponibles();                                 // Q3
    List<Vehicule> searchVehiculesByMarque(String keyword);                   // Q5

    List<Vehicule> getVehiculesTarifSuperieurA(BigDecimal tarif);   // Q8               // Q8
    List<Vehicule> getVehiculesByMarqueEtStatut(String marque, StatutVehicule statut); // Q11

}