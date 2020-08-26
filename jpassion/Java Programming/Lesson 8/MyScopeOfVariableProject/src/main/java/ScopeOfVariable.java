
public class ScopeOfVariable {

    public static void main(String[] args) {

        int var1 = 10;
        int var2 = 20;
        if (var1 < 100) {
            var2 = 20;
        } else {
            var2 = 21;
        }

        // Access to var1 is allowed so no compile error.
        System.out.println("value of var1 = " + var1);

        // Access to var2 is not allowed so compile error will be generated
        System.out.println("value of var2 = " + var2);
    }

}
