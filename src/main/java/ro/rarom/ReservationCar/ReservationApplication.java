package ro.rarom.ReservationCar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.rarom.ReservationCar.model.CarName;
import ro.rarom.ReservationCar.model.ReservationCar;
import ro.rarom.ReservationCar.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp(ReservationRepository repository){
		List<ReservationCar> cars = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			// get random marca
			int indMarca = new Random().nextInt(5);
			CarName marca = CarName.values()[indMarca];
			String[] desc = new String[] {"full option", "not full option"};
			int indDesc = new Random().nextInt(2);
			String description = desc[indDesc];
			int price = new Random().nextInt(500,1700);
			ReservationCar car = new ReservationCar(price, description,marca);
			cars.add(car);
		}
		// avem o lista de 101 masini
		return args -> {
			repository.saveAll(
//					List.of(
//						new ReservationCar(500, "full option", CarName.BMW),
//						new ReservationCar(333, "not full option", CarName.DACIA),
//						new ReservationCar(200, "full option", CarName.FORD),
//						new ReservationCar(555, "full option", CarName.BMW),
//						new ReservationCar(500, "full option", CarName.BMW)
//					)
					cars
			);
		};
	}

}
