package com.mycompany.myowneventexample;

import java.io.Serializable;
import java.util.ArrayList;

public class MyOwnEventSource implements Serializable {

    ArrayList<MyOwnEventListenerInterface> listeners;

    public MyOwnEventSource() {
        listeners = new ArrayList<>();
    }

    public void addMyOwnEventListener(MyOwnEventListenerInterface l) {
        listeners.add(l);
    }

    public void removeMyOwnEventListener(MyOwnEventListenerInterface l) {
        listeners.remove(l);
    }

    public void triggerMyOwnEvent() {
        listeners.forEach(item -> {
            item.getCurrentDate(new MyOwnEvent(this));
        });
    }
}
