package mypackage;

import java.util.logging.Level;
import java.util.logging.Logger;

class ChildLogger {

    private Logger logger = Logger.getLogger("sam.logging.child");

    private Level level = null;

    public void aMethod() {
        logger.log(Level.INFO, "Info message from Child Logger");
        logger.log(Level.SEVERE, "Severe message from Child Logger");
    }
}
