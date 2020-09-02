import java.io.Serializable;
import java.util.ArrayList;

public class MyEventSource implements Serializable {
    
    // Maintain the event listeners
    ArrayList a1 = new ArrayList();
    
    /** Creates a new instance of MyEventSource */
    public MyEventSource() {
    }
    
    public void addMyEventListener(MyEventListenerInterface l){
        a1.add(l);
    }
    
    public void removeMyEventListener(MyEventListenerInterface l){
        a1.remove(l);
    }
    
    public void triggerSomethingEvent(String eventName){
        
        // Invoke event listener
        for (Object item: a1){
            MyEventListenerInterface m1 = (MyEventListenerInterface)item;
            m1.somethingHappened(new MyEvent(this, eventName));
        }
    }
}
