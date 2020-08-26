package com.mycompany.myinstanceofoperatorproject;

public class instanceofOperator {

    public static void main(String[] args) {

        // Create String object instance
        String str1 = "Life is worth living... with Passion!";
        Integer int1 = new Integer(40);
        Long lng1 = new Long(255657);

        // Check if str1 is String type using instanceof operator.
        // Check also if it is Object type.
        boolean b1 = str1 instanceof String;
        System.out.println("str1 is String type: " + b1);
        boolean b2 = str1 instanceof Object;
        System.out.println("str1 is Object type: " + b2);

        // Check if int1 is Integer type using instanceof operator.
        // Check also if it is Object type.
        b1 = int1 instanceof Integer;
        System.out.println("int1 is Integer type: " + b1);
        b2 = int1 instanceof Object;
        System.out.println("int1 is Object type: " + b2);
        b2 = int1 instanceof Number;
        System.out.println("int1 is Number type: " + b2);

        b1 = lng1 instanceof Long;
        System.out.println("lng1 is Long type: " + b1);
        b2 = lng1 instanceof Object;
        System.out.println("lng1 is Object type: " + b2);
        b2 = lng1 instanceof Number;
        System.out.println("lng1 is Number type: " + b2);
    }
}
