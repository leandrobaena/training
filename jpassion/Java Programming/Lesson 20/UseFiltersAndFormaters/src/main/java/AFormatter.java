import java.util.logging.*;

class AFormatter extends Formatter {
  // this class extends the abstract class Formatter
    //we have to override only the format(...) method
    //this method is taking the message who is coming on two lines
    //and is returnig the message only on one line
  public String format(LogRecord record) {
     return record.getLevel() + " [" + record.getSourceClassName() +
             ":" + record.getSourceMethodName() + "] " + 
             record.getMessage() + "\n" + record.getMillis();
  }
}
