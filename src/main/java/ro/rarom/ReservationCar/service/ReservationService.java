package ro.rarom.ReservationCar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.rarom.ReservationCar.model.ReservationCar;
import ro.rarom.ReservationCar.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    public List<ReservationCar> getAllReservation(ReservationCar reservationCar, Double maxPrice) {
        return repository.findAll();
    }

    public Optional<ReservationCar> getReservationById(int reservationId) {
        return repository.findById(reservationId);
    }

    public ReservationCar addReservation(ReservationCar table) {
        return repository.save(table);
    }
    public ReservationCar deleteReservationById(int reservationId){
        Optional<ReservationCar> inventoy = repository.findById(reservationId);
        inventoy.ifPresent(repository::delete);
        return inventoy.orElse(null);
    }
}
