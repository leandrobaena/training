
package finallyworks;

class MyException extends Exception {
}

public class Main {
    
    static int count = 0;
    
    public static void main(String[] args) {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0)
                    throw new MyException();
                System.out.println("No exception");
            } catch (MyException e) {
                System.out.println("MyException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2)
                    break; // out of "while"
            }
        }
    }
} 