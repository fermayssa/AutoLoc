package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import java.math.BigDecimal;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Q1 : véhicules d'une marque précise
    List<Vehicule> findByMarque(String marque);

    // Q2 : véhicules d'une catégorie donnée
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Q3 : véhicules selon un statut (DISPONIBLE)
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Q5 : marque contenant une chaîne (insensible à la casse)
    List<Vehicule> findByMarqueContainingIgnoreCase(String marque);

    // Q8 : tarif journalier supérieur à une valeur
    // Q8
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);
    // Q11 : marque ET statut
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
}