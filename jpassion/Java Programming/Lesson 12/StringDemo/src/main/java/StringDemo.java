
class StringDemo {
    
    public static void main(String args[]) {
        
        String name = "Jonathan";
        System.out.println("name: " + name);
        
        //  Return the char value at the specified index.
        System.out.println("3rd character of name: " +
                name.charAt(2)); // n
        
        // Convert the string to a new character array.
        char charArr[] = "Hi XX".toCharArray();
        System.out.print("charArr = ");
        for (char c: charArr) {
            System.out.print(c);
        }
        System.out.println("");
        
        char charArr2[] = new char[20];
        "Jonathan".getChars(0, 2, charArr2, 3);
        System.out.print("charArr2 = ");
        for (char c: charArr2) {
            System.out.print(c);
        }
        System.out.println("");
        
        // String length
        System.out.println("Length of name: " +
                name.length());
        
        System.out.println("Replace a's with e's in name: " +
                name.replace('a', 'e')); // Jonethen

        // Returns a new string that is a substring of this string. 
        // The substring begins at the specified beginIndex and 
        // extends to the character at index endIndex - 1
        System.out.println("A substring of name: " +
                name.substring(0, 2)); // Jo
        
        System.out.println("Trim \"  a b c d e f   \": \"" +
                "  a b c d e f   ".trim() + "\""); // a b c d e f
        
        System.out.println("String representation of boolean expression 10>10: " 
                + String.valueOf(10>10));
        
        // toString method is implicitly called in the println
        // method
        System.out.println("String representation of boolean expression 10<100: " 
                + (10<100));
        
        // Note there's no change in the String object name
        // even after applying all these methods. 
        System.out.println("name: " + name);
    }
}
