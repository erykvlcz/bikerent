package pl.kurs.models;

public class Bike {
    private String id;
    private String color;

    public Bike(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public void repaintBike(String newColor) {
        this.color = newColor;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                '}';
    }
}
