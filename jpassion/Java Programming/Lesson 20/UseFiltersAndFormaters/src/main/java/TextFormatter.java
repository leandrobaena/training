import java.util.logging.*;
import java.util.Date;

/*
 *we'll format the LogRecord so when the Level will be SEVERE 
 * before the actual level will have an Attention message
 */

class TextFormatter extends Formatter {

  // This method is called for every log record

  public String format(LogRecord rec) {
  
   StringBuffer sb = new StringBuffer(1000);

   // give a red color to any messages with levels >= WARNING
   if (rec.getLevel().intValue() >= Level.SEVERE.intValue()) {
       sb.append("Attention, Attention, Attention  "); 
       sb.append(rec.getLevel());
         } else {
        sb.append(rec.getLevel());
        
      }
      sb.append(' ');
      sb.append(formatMessage(rec));
      sb.append('\n');
      return sb.toString();
    }

    // This method is called when the handler is created
  public String getHead(Handler h) 
  {
     
      return "The date is : "+new Date()+"\n";
  }
  //This method is called when the handler finised publishing 
  public String getTail(Handler h) 
  {
      return "End of log at time : "+new Date()+"\n\n";
  }
  }