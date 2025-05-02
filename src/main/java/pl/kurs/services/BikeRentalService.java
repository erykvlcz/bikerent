package pl.kurs.services;

import pl.kurs.models.Bike;
import pl.kurs.models.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BikeRentalService {
    private String name;

    private Map<Bike, Map<LocalDate, User>> availableBikes = new HashMap<>();

    public BikeRentalService(String name) {
        this.name = name;
    }

    public void addBikeToRent(Bike bike){
        availableBikes.put(bike, new HashMap<>());
    }

    public void reserveBike(Bike bike, LocalDate date, User user){
        isBikeInOffer(bike);

        if(isBikeReserved(bike, date)){
            throw new IllegalArgumentException("W tym momencie rower nie jest dostępny");
        }

        availableBikes.get(bike).put(date, user);
    }

    public void rentBike(User user, Bike bike, LocalDate date){
        if(showPersonWhoReserveBike(user, bike, date) == user){
            user.addToRentHistoryList(date, bike);
            user.addToActualRentedBikesList(date, bike);
            System.out.println("Wypożycozno rower");
        }
    }

    public void cancelReservation(User user, Bike bike, LocalDate date){
        isBikeInOffer(bike);  // sprawdzenie, czy rower jest w ofercie

        if (!isBikeReserved(bike, date)) {
            System.out.println("Tego dnia nie było żadnej rezerwacji dla tego roweru.");
            return;
        }

        Map<LocalDate, User> reservations = availableBikes.get(bike);
        User reservedUser = reservations.get(date);

        if (!reservedUser.equals(user)) {
            System.out.println("Tego dnia rower był zarezerwowany przez innego użytkownika.");
            return;
        }

        // Jeśli wszystko się zgadza – usuwamy rezerwację
        reservations.remove(date);
        System.out.println("Rezerwacja anulowana.");


    }

    public void showAvailableDays(Bike bike){
        System.out.println("Rower jest dostępny we wszystkich terminach oprócz: ");
        isBikeInOffer(bike);
        Map<LocalDate, User> reservations = availableBikes.get(bike);

        if (reservations.isEmpty()) {
            System.out.println("Brak rezerwacji – rower jest w pełni dostępny.");
        } else {
            for (LocalDate date : reservations.keySet()) {
                System.out.println("Data: " + date);
            }
        }
    }

    private void isBikeInOffer(Bike bike){
        if(!availableBikes.containsKey(bike)){
            throw new IllegalArgumentException("Takiego roweru nie ma w ofercie");
        }
    }

    private boolean isBikeReserved(Bike bike, LocalDate date){
        if(availableBikes.containsKey(bike)){
            Map<LocalDate, User> reservationsMap = availableBikes.get(bike);
            if(reservationsMap.containsKey(date)){
                return true;
            }
        }
        return false;
    }

    private User showPersonWhoReserveBike(User user, Bike bike, LocalDate date){
        Map<LocalDate, User> reservationsMap = availableBikes.get(bike);
        if(reservationsMap.containsValue(user)){
            return user;
        }else {
            throw new IllegalArgumentException("Taka osoba nie zrobiła wecześniejszej rezerwacji");
        }
    }


    @Override
    public String toString() {
        return "BikeRentalService{" +
                "name='" + name + '\'' +
                '}';
    }
}
