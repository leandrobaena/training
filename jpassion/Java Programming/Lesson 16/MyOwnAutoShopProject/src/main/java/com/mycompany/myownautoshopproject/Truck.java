package com.mycompany.myownautoshopproject;

public class Truck extends Car {

    private int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return super.getSalePrice() - (super.getSalePrice() * 0.1);
        } else {
            return super.getSalePrice() - (super.getSalePrice() * 0.2);
        }
    }
}
