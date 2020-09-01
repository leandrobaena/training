package catchingexceptionhierarchy;

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
        } 
    }
} 