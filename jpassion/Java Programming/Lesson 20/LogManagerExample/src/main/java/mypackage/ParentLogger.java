package mypackage;


import java.util.logging.Level;
import java.util.logging.Logger;


class ParentLogger{
    private Logger logger = Logger.getLogger("sam.logging");
    private Level level = null;
    
    public ParentLogger(){
        level = Level.SEVERE;   // Try Level.INFO, Try Level.OFF as well
        //setting the level as SEVERE
        logger.setLevel(level);
    }
    
    public void aMethod() {
        logger.log(level, "Severe message from Parent Logger");
    }
}

