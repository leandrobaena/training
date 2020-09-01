import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseFilters {
    
    // A Logger object is used to log messages for a specific system
    // or application component. Loggers are normally named, using a
    // hierarchical dot-separated namespace. Logger names can be arbitrary
    // strings, but they should normally be based on the package name or
    // class name of the logged component. In addition it is possible
    // to create "anonymous" Loggers that are not stored in the Logger
    // namespace.
    private static Logger logger = Logger.getLogger("loggerdemo");
    
    public static void main(String[] args) throws Exception {
        //create a custom Filter
        //only one Filter can be used for a logger so the other one has to
        //be commented
        //logger.setFilter(new CustomFilter());//uncomment this Filter if you want 
                                                //to see only INFO level messages
                                                 //and also then the AltFilter has to 
                                                 //be commented, otherwise only the last one 
                                                 //will be in action
        logger.setFilter(new AltFilter());//this filter customize the messages that 
                                            //can be seen so we will be seing only the ones
                                             //whom's message is equal with "dividing by 0"
                                             //from condition.
                                             //Comment this filter if you want to see the 
                                             //CustomFilter
        
        // Log a INFO tracing message
        logger.info("doing stuff");
        
        try{
            System.out.println(3/0);
        } catch(Exception e){
            logger.log(Level.SEVERE,"dividing by 0");
        }
        
        logger.info("done");
    }
    
}
