package mypackage;

public class OuterClass {

    // Define a variable in the outer class
    private int privateData = 5;
    protected int protectedData = 6;
    int defaultData = 7;
    public int publicData = 8;

    private String myOuterMethod() {
        return "myOuterMethod() has been called!";
    }

    // Define an Static nested class
    static class StaticNestedClass {

        int data2 = 10;

        void myStaticNestedMethod() {
            // The following line results in compile error.  Static nested
            // class cannot access instance variables of the outer class
            //System.out.println("data from OuterClass = " + defaultData);
            //System.out.println("call a method of OuterClass = " + myOuterMethod());

            // It can use them only through an object reference just like any
            // other top-level class.
            OuterClass outerObject = new OuterClass();
            System.out.println("data from OuterClass object = " + outerObject.privateData);
            System.out.println("data from OuterClass object = " + outerObject.protectedData);
            System.out.println("data from OuterClass object = " + outerObject.defaultData);
            System.out.println("data from OuterClass object = " + outerObject.publicData);
            
            System.out.println("data2 from StaticNestedClass = " + data2);
        }

    }
}
