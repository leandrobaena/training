
class StringObjectComparison {

    public static void main(String args[]) {

        // Compare two String objects instances
        String string1 = new String("JPassion");
        String string2 = new String("JPassion");  // This creates a new String object
        System.out.println("Is string1 == string2? " + (string1 == string2)); // false
        
        // Compare Sting literal. String literal is a single String instance
        String string3 = "JPassion";
        String string4 = "JPassion";
        System.out.println("Is string3 == string4? " + (string3 == string4)); // true    
        
        // Use equals method of String class
        String name = "Jonathan";
        System.out.println("Is Jonathan equal to Jonathan? "
                + name.equals("Jonathan"));
        System.out.println("Is Jonathan equal to jonathan? "
                + name.equals("jonathan"));
        System.out.println("Is Jonathan equal to jonathan (ignore case)? " 
                + name.equalsIgnoreCase("jonathan"));
   
    }
}
