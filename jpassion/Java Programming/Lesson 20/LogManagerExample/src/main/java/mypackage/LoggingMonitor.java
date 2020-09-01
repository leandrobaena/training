package mypackage;

import java.util.Enumeration;
import java.util.logging.LogManager;

public class LoggingMonitor {

    public static void main(String[] args) {
        ParentLogger pLogger = new ParentLogger();
        ChildLogger cLogger = new ChildLogger();

        LogManager logManager = LogManager.getLogManager();
        Enumeration<String> loggerNames = logManager.getLoggerNames();
        while (loggerNames.hasMoreElements()) {
            System.out.println("Logger name = " + loggerNames.nextElement());
        }
        cLogger.aMethod();
    }
}