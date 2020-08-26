package com.mycompany.myownclassproject;

public class Main {

    public static void main(String[] args) {
        String[] names = args;
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(generateNewName(names));
    }

    public static String generateNewName(String[] arr) {
        String newName = "";
        for (String item : arr) {
            newName += item.charAt(1);
        }
        return newName;
    }
}
