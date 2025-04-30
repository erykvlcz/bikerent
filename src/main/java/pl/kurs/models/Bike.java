package pl.kurs.models;

public class Bike {
    private String id;

    public Bike(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                '}';
    }
}
