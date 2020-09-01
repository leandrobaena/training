package exceptiondemo;

public class Main {
    
    public static void main(String[] argv) {
        new Main().doTheWork();
    }
    
    /** This method demonstrates calling a method that might throw
     * an exception, and catching the resulting exception.
     */
    public void doTheWork() {
        Object o = null;
        
        for (int i=0; i<5; i++) {
            
            o = makeObj(i);
            
            System.out.println("i = " + i + " Object = " + o);  // process the created object in some way
        }
    }
    
    /** Model of a method that creates and returns an object.
     * This method is really here to show how you throw exceptions.
     * @exception  IllegalArgumentException  if called with value 1.
     */
    public Object makeObj(int type) throws IllegalArgumentException {
        if (type == 1)  // detects an error...
            throw new IllegalArgumentException("Don't like type " + type);
        return new Object();
    }
}