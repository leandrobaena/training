package mypackage;

public class OuterClass {

    // Define variables in the outer class
    private int privateData = 5;
    protected int protectedData = 6;
    int defaultData = 7;
    public int publicData = 8;

    // Define an inner class
    class InnerClass {

        static final int data2 = 10;

        void myInnerClassMethod() {
            System.out.println("data from OuterClass = " + privateData);
            System.out.println("data from OuterClass = " + protectedData);
            System.out.println("data from OuterClass = " + defaultData);
            System.out.println("data from OuterClass = " + publicData);
            System.out.println("call a method of OuterClass = " + myOuterMethod());
            System.out.println("data2 from InnerClass = " + data2);
        }
    }

    private String myOuterMethod() {
        return "myOuterMethod() has been called!";
    }
}
