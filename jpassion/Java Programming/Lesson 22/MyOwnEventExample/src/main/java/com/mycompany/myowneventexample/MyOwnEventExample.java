package com.mycompany.myowneventexample;

public class MyOwnEventExample {

    public static void main(String[] args) {
        // Create an event source
        MyOwnEventSource s1 = new MyOwnEventSource();

        // Register an event listener to the event source
        s1.addMyOwnEventListener(new MyOwnListenerImpl());

        // Triger an event
        s1.triggerMyOwnEvent();
    }
}
