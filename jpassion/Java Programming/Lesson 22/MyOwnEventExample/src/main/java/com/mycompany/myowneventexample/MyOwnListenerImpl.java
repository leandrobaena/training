package com.mycompany.myowneventexample;

public class MyOwnListenerImpl implements MyOwnEventListenerInterface {

    @Override
    public void getCurrentDate(MyOwnEvent myOwnEvent) {
        System.out.println("La fecha actual es " + myOwnEvent.getCurrentTime());

    }
}
