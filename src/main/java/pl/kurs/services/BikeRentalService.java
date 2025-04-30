package pl.kurs.services;

public class BikeRentalService {
    private String name;

    public BikeRentalService(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BikeRentalService{" +
                "name='" + name + '\'' +
                '}';
    }
}
