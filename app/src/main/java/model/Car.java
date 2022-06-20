package model;

import java.io.Serializable;

public class Car implements Serializable {
     private String id;
     private String brand;
     private String color;
     private float price;

    public Car(String id, String brand, String color, float price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
