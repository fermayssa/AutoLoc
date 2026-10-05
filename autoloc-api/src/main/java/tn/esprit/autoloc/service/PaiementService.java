package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementService implements IPaiementService {

    PaiementRepository paiementRepo;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) paiementRepo.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement p) {
        return paiementRepo.save(p);
    }

    @Override
    public Paiement updatePaiement(Paiement p) {
        return paiementRepo.save(p);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepo.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepo.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiements) {
        return (List<Paiement>) paiementRepo.saveAll(paiements);
    }
}