package pl.kurs.models;

public class Bike {
    private String id;
    private String color;

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
