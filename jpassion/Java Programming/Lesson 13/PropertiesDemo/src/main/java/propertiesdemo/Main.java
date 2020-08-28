package propertiesdemo;

import java.util.*;

class Main {

    public static void main(String args[]) {
        Properties myCountryProperties = new Properties();
        Set countries;
        String str;

        myCountryProperties.put("U.S.A.", "D.C.");
        myCountryProperties.put("Korea", "Seoul");
        myCountryProperties.put("France", "Paris");
        myCountryProperties.put("Japan", "Tokyo");

        countries = myCountryProperties.keySet();
        Iterator itr = countries.iterator();
        while (itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of "
                    + str + " is "
                    + myCountryProperties.getProperty(str));
        }
        System.out.println();
        str = myCountryProperties.getProperty("China", "Not Found");
        System.out.println("The capital of China is " + str + ".");
    }
}
