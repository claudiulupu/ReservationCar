package ro.rarom.ReservationCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.ReservationCar.model.ReservationCar;

public interface ReservationRepository extends JpaRepository<ReservationCar, Integer> {

}
