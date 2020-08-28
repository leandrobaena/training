
class StringLexComparison {

    public static void main(String args[]) {

        String name = "Jonathan";
        System.out.println("name: " + name);

        // Character that first appears alphabetically
        // has lower unicode value 
        
        System.out.println("Jonathan compared to Solomon: "
                + name.compareTo("Solomon"));
        System.out.println("Solomon compared to Jonathan: "
                + "Solomon".compareTo("Jonathan"));
        // 'J' has lower unicode value compared to 'j' 
        System.out.println("Jonathan compared to jonathan: "
                + name.compareTo("jonathan"));

        System.out.println("Jonathan compared case ignored:"
                + name.compareToIgnoreCase("jonathan"));

    }
}
