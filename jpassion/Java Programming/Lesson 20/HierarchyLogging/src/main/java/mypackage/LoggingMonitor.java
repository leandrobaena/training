package mypackage;

public class LoggingMonitor {

    public static void main(String[] args) {
        ParentLogger pLogger = new ParentLogger();
        ChildLogger cLogger = new ChildLogger();
        cLogger.aMethod();
    }
}
