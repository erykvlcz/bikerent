package pl.kurs.app;

import pl.kurs.models.Bike;
import pl.kurs.models.User;
import pl.kurs.services.BikeRentalService;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        Bike bike = new Bike("skladak1");
        Bike bike2 = new Bike("skladak2");
        User user = new User("Seba", 20);
        User user2 = new User("Zbychu", 40);
        BikeRentalService service = new BikeRentalService("Bikerrents");

        service.addBikeToRent(bike);
        service.addBikeToRent(bike2);
        service.reserveBike(bike, LocalDate.of(2020, 5, 13), user);
        service.rentBike(user, bike2, LocalDate.of(2020, 5, 13));
    }
}
