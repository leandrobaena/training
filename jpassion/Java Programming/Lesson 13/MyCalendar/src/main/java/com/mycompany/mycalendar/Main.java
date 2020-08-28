package com.mycompany.mycalendar;

import java.util.Calendar;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
        System.out.println("Fecha: " + cal.get(Calendar.DATE));
        System.out.println("Hora: " + cal.get(Calendar.HOUR));
    }
}
