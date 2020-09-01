import java.util.Date;
import java.util.logging.*;

class LineFormatter extends Formatter {
  // this class extends the abstract class Formatter
    //we have to override only the format(...) method
    //this method is taking the message who is coming on two lines
    //and is returnig the message only on one line
  public String format(LogRecord record) {
     return record.getLevel() + ":"+ record.getMessage()+" on the date : " +new Date()+ "\n" ;
  }
}
