package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Arrays;

public class Car {
    private final boolean isRunAndDrive;
    private final int age;
    private final String model;
    private final Seller seller;
    private final String[] other;

    public Car(boolean isRunAndDrive, int age, String model, Seller seller, String[] other) {
        this.isRunAndDrive = isRunAndDrive;
        this.age = age;
        this.model = model;
        this.seller = seller;
        this.other = other;
    }

    @Override
    public String toString() {
        return "Car{" + "isRunAndDrive=" + isRunAndDrive + ", age=" + age
                + ", model='" + model + '\'' + ", seller=" + seller
                + ", other=" + Arrays.toString(other) + '}';
    }

    private static class Seller {
        private final String name;
        private final String phone;

        public Seller(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Seller{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        final Car myNewCar = new Car(true, 10, "Nissan",
                new Seller("Ivan", "+79994442211"), new String[]{"No scratches", "One owner"});
        System.out.println(myNewCar);
        Gson gson = new GsonBuilder().create();
        String jsCar = gson.toJson(myNewCar);
        System.out.println(jsCar);
        final Car deserializedCar = gson.fromJson(jsCar, Car.class);
        System.out.println(deserializedCar);
    }
}
