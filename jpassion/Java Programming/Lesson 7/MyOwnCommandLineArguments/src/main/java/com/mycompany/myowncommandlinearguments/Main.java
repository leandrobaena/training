package com.mycompany.myowncommandlinearguments;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2 || args.length % 2 == 1) {
            System.out.println("Error en el número de parámetros");
            System.exit(0);
        } else {
            int average = 0;
            for (int i = 0; i < args.length - 1; i += 2) {
                average += Integer.parseInt(args[i + 1]);
            }
            System.out.println("El promesio de las edades es " + average / (args.length / 2));
        }
    }
}
