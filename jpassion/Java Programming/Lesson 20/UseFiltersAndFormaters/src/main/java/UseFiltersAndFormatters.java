import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class UseFiltersAndFormatters {
    
    // A Logger object is used to log messages for a specific system
    // or application component. Loggers are normally named, using a
    // hierarchical dot-separated namespace. Logger names can be arbitrary
    // strings, but they should normally be based on the package name or
    // class name of the logged component. In addition it is possible
    // to create "anonymous" Loggers that are not stored in the Logger
    // namespace.
    private static Logger logger = Logger.getLogger("loggerdemo");

    private static Handler[] handlers;
    
    public static void main(String[] args) throws Exception {
        //I use the next method to make it clearer how the Formmater class is 
        //working over the Console handler
        //otherwise would be two Console Handlers:the default and the one I create
        //and would be confusing
        logger.setUseParentHandlers(false) ;
        //create a custom Filter
        //only one Filter can be used for a logger so the other one has to
        //be commented
        //logger.setFilter(new CustomFilter());//uncomment this Filter if you want 
                                                //to see only INFO level messages
                                                 //and also then the AltFilter has to 
                                                 //be commented, otherwise only the last one 
                                                 //will be in action
        logger.setFilter(new AltFilter());//this filter custmize the messages that 
                                            //can be seen so will be seing only the ones
                                             //who's message is equal with "dividing by 0"
                                             //from condition
                                             //comment this filter if you want to see the 
                                             //CustomFilter
        // Add File Handler and set the Formatter to TextFormatter
        FileHandler fh=new FileHandler("mylog.txt", true);
        fh.setFormatter(new TextFormatter());
        logger.addHandler(fh);
               // will set here the Formatter of Console Handler to LineFormatter
        ConsoleHandler ch=new ConsoleHandler();
        ch.setFormatter(new LineFormatter());
        logger.addHandler(ch);
        
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
