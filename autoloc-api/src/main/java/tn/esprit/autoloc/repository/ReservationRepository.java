package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.autoloc.domain.Reservation;
import java.time.LocalDate;
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByDateDebutAfter(LocalDate date);
}