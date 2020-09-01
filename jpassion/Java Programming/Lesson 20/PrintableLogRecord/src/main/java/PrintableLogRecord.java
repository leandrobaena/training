// : c15:PrintableLogRecord.java
// Override LogRecord toString()
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class PrintableLogRecord extends LogRecord {
    
    public PrintableLogRecord(Level level, String str) {
        super(level, str);
    }
    
    public String toString() {
        String result = "Level<" + getLevel() + ">\n" + "LoggerName<"
                + getLoggerName() + ">\n" + "Message<" + getMessage() + ">\n"
                + "CurrentMillis<" + getMillis() + ">\n" + "Params";
        Object[] objParams = getParameters();
        if (objParams == null)
            result += "<null>\n";
        else
            for (int i = 0; i < objParams.length; i++)
                result += "  Param # <" + i + " value "
                        + objParams[i].toString() + ">\n";
        result += "ResourceBundle<" + getResourceBundle()
        + ">\nResourceBundleName<" + getResourceBundleName()
        + ">\nSequenceNumber<" + getSequenceNumber()
        + ">\nSourceClassName<" + getSourceClassName()
        + ">\nSourceMethodName<" + getSourceMethodName()
        + ">\nThread Id<" + getThreadID() + ">\nThrown<" + getThrown()
        + ">";
        return result;
    }
    
    public static void main(String[] args) {
        PrintableLogRecord logRecord = new PrintableLogRecord(Level.FINEST,
                "Simple Log Record");
        System.out.println(logRecord);
    }
} ///:~