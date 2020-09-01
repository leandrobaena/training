// : c15:SimpleFilter.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleFilter {
    
    private static Logger logger = Logger.getLogger("SimpleFilter");
    
    static class Duck {
    };
    
    static class Wombat {
    };
    
    static void sendLogMessages() {
        logger.log(Level.WARNING, "Duck!", new Duck());
        logger.log(Level.WARNING, "Wombat!", new Wombat());
    }
    
    public static void main(String[] args) {
        System.out.println("---------Before setting filter..-------");
        sendLogMessages();
        
        // Set the filter - only log Duck
        logger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord record) {
                Object[] params = record.getParameters();
                if (record.getParameters()[0] instanceof Duck)
                    return true; // Only log Ducks
                return false;
            }
        });
        System.out.println("---------After setting filter..-------");
        sendLogMessages();
        
    }
} ///:~
