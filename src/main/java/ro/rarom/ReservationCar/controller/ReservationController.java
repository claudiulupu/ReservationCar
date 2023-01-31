package ro.rarom.ReservationCar.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ro.rarom.ReservationCar.exception.ResourceNotFoundException;
import ro.rarom.ReservationCar.model.ReservationCar;
import ro.rarom.ReservationCar.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;


    @GetMapping
    List<ReservationCar> getAll(@RequestParam(required = false) ReservationCar reservationTable,
                                @RequestParam(required = false) Double maxPrice) {
        return service.getAllReservation(reservationTable, maxPrice);
    }

    @GetMapping("{reservationId}")
    ReservationCar getReservationById(@PathVariable int reservationId){
        return service.getReservationById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product with id " + reservationId));
    }
    @PostMapping
    ReservationCar addReservation(@RequestBody ReservationCar table){
        return service.addReservation(table);
    }
    @DeleteMapping("{reservationId}")
    void deleteReservationById(@PathVariable int reservationId){
        service.deleteReservationById(reservationId);
    }
}
