import java.util.logging.*;
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
 *Each logger can use one Filter class by using the setFilter(Filter obj) method
 *This Filter class will make that logger visible or not deppending of the 
 *value returned by the boolean condition.
 *In this example I am using a Filter who's boolean condition is 
 *upon the String parameter of the logger.
 *If the String from the logger is different that the one in the if 
 *condition than the logger will not be visible
 */

class AltFilter implements Filter {
  
  public boolean isLoggable(LogRecord record) {
    String msg = record.getMessage();
    if (msg != "dividing by 0") {
      return false;  // not an important message
    }
    else {
      return true;   // important error and message so we want to see it
    }
  }
}

