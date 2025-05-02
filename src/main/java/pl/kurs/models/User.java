package pl.kurs.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private Map<LocalDate, Bike> rentHistoryList = new HashMap<>();
    private Map<LocalDate, Bike> actualRentedBikesList = new HashMap<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addToRentHistoryList(LocalDate localDate, Bike bike){
        rentHistoryList.put(localDate, bike);
    }

    public void addToActualRentedBikesList(LocalDate localDate, Bike bike){
        rentHistoryList.put(localDate, bike);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
