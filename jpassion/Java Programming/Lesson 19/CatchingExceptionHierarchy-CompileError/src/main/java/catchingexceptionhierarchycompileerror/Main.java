package catchingexceptionhierarchycompileerror;

class MyParentException extends Exception {
}

class MyChildException extends MyParentException {
}

public class Main {
    
    public static void main(String[] args) {
        try {
            throw new MyChildException();
        } catch (MyParentException s) {
            System.err.println("Caught MyParentException");
        } catch (MyChildException a) {  // Compile error expected
            System.err.println("Caught MyChildtException");
        }
    }
} 
