package com.mycompany.myownautoshopproject;

public class MyOwnAutoShop {

    public static void main(String[] args) {
        Sedan sedan1 = new Sedan(150, 35000000, "rojo", 3);
        Ford ford1 = new Ford(180, 45000000, "azul", 2018, 1000000);
        Ford ford2 = new Ford(210, 65000000, "negro", 2019, 500000);
        Car car1 = new Car(120, 25000000, "blanco");

        System.out.println("Precio sedan1 " + sedan1.getSalePrice());
        System.out.println("Precio ford1 " + ford1.getSalePrice());
        System.out.println("Precio ford2 " + ford2.getSalePrice());
        System.out.println("Precio car1 " + car1.getSalePrice());
    }
}
