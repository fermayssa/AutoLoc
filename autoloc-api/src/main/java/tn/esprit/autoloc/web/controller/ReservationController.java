package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Reservation")
public class ReservationController {

    private final IReservationService ir;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return ir.addReservation(r);
    }

    @PostMapping("/addReservations")
    public List<Reservation> addReservations(@RequestBody List<Reservation> reservations) {
        return ir.addReservations(reservations);
    }

    @GetMapping("/getReservations")
    public List<Reservation> getAllReservations() {
        return ir.retrieveAllReservations();
    }

    @GetMapping("/getReservation/{id}")
    public Reservation getReservation(@PathVariable("id") Long idReservation) {
        return ir.retrieveReservation(idReservation);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return ir.updateReservation(r);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable("id") Long idReservation) {
        ir.removeReservation(idReservation);
    }
}