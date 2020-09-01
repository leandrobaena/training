import java.util.logging.*;
//import java.util.logging.Filter;

/*I've used the log method of Logger class who has this signature:
 *      log(Level level, String msg);
 *A log message can be called in 2 ways:
 *  1) call the Logger's method log(...) with two parameters
 *      exp: logger.log(Level.WARNING, "This is a warning");
 *  2) call a method named for a well known priority
 *      exp: severe(...), warning(...), info(...), 
 *          and pass in a parameter of String data
 *              like here:logger.warning("This is a warning");
 *Either way a log message has 2 parameters ( a level, and a String)
 *on which we can apply boolean conditions.
 *This boolean conditions can be saved in a class that implements Filter
 *Each logger can use one filter class by using the setFilter(Filter obj) method
 *This filter class will make that logger visible or not deppending of the 
 *value returned by the boolean condition.
 *In this example I am using a Filter who's boolean condition is 
 *upon the Level parameter of the logger.
 *If the Level parameter is different than the one in 
 *condition, than the logger will not be visible
 */

class CustomFilter implements Filter 
{
static int count=0;
// The method should return false when we do not wish
// to log the message

public boolean isLoggable(LogRecord record) {
if (record.getLevel().intValue() == Level.INFO.intValue())
       return true;
   else
       
       return false;
  }
}