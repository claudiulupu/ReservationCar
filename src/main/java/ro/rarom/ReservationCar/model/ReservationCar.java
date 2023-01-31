package ro.rarom.ReservationCar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ReservationCar {
    @Id
    @GeneratedValue
    private int id;
    private int price;
    private String description;
    private CarName name;

    public ReservationCar(int price, String description, CarName name) {
        this.price = price;
        this.description = description;
        this.name = name;
    }
}
