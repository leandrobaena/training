package com.mycompany.myowneventexample;

import java.util.Date;
import java.util.EventObject;

public class MyOwnEvent extends EventObject {

    public MyOwnEvent(Object source) {
        super(source);
    }

    public Date getCurrentTime() {
        return new Date();
    }
}
