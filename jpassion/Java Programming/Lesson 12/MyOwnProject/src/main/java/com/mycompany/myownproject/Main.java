package com.mycompany.myownproject;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties myProperties = new Properties();
        String myValue20 = "20", myValue30 = "30", myValue40 = "40";

        myProperties.setProperty("mykey20", myValue20);
        myProperties.setProperty("mykey30", myValue30);
        myProperties.setProperty("mykey40", myValue40);

        myProperties.list(System.out);
    }
}
