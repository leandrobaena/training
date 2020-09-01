package myaccessmodifierexampleproject;

public class DummyClass {

    // Private field. Can be accessed only within the
    // same class.
    private String s1 = "private string";

    // Protected field. Can be accessed within the package.
    // Also can be accessed by subclasses of this this class
    // even if the class is in different package.
    protected String s2 = "protected string";

    // Public field. Can be accessed from anybody.
    public String s3 = "public string";

    // This is default scope.  It can be accessed within
    // classes of the same pacakge.
    String s4 = "string without access modifier";

    // Private method. Can be accessed only within the
    // same class.
    private void method1() {
    }

    // Protected field. Can be accessed within the package.
    // Also can be accessed by subclasses of this this class
    // even if the class is in different package.
    protected void method2() {
    }

    // Public method. Can be accessed from anybody.
    public void method3() {
    }

    // This is default scope.  It can be accessed within
    // classes of the same pacakge.
    void method4() {
    }
}
