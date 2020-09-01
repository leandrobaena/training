
package callstack;

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        
        int count = 1000000;
        Stack s = new Stack();
        
        System.out.println("Testing for empty stack");
        long s1 = System.currentTimeMillis();
        for (int i = 0; i <= count; i++){
            if (!s.empty()){
                System.out.println(i + s.peek().getClass().getName());
                s.pop();
            }
        }
        long s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) + " milliseconds");
        
        System.out.println("Catching EmptyStackException");
        s1 = System.currentTimeMillis();
        for (int i = 0; i <= count; i++) {
            try {
                System.out.println(i + s.peek().getClass().getName());
                s.pop();
            } catch (EmptyStackException e) {
            }
        }
        s2 = System.currentTimeMillis();
        System.out.println((s2 - s1) + " milliseconds");
    }
    
}
