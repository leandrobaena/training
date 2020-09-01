import javax.swing.*;

// This is my custom exception
class InvalidHexException extends RuntimeException {
}

class HexToDec {
    
    // This method throws a custom exception called InvalidException
    static int [] convertToInt(String hex) throws InvalidHexException {
        char currChar;
        int intEq[] = new int[hex.length()];
        for (int i = 0; i < hex.length(); i++) {
            currChar = hex.charAt(i);
            if (currChar >= '0' && currChar <='9') {
                intEq[i] = currChar - '0';
            } else if (currChar >= 'a' && currChar <='f') {
                intEq[i] = currChar - 'a' + 10;
            } else if (currChar >= 'A' && currChar <='F' ) {
                intEq[i] = currChar - 'A' + 10;
            } else {
                throw new InvalidHexException();
            }
        }
        return intEq;
    }
    
    static int convertToDec(int intEq[]) {
        int result = 0;
        int mult = 1;	//multiplier
        for (int j = intEq.length - 1; j >= 0; j--) {
            result += intEq[j]*mult;
            mult *= 16;
        }
        return result;
    }
    
    public static void main(String args[]) {
        String hex;
        int intEq[];
        
        // Receive hex value from a user
        hex = JOptionPane.showInputDialog(null, "Input hex: ");
        try {
            
            // convertToInt() method will throw InvalidHexExceptions if
            // the value is not in a valid format
            intEq = convertToInt(hex);
            
            Integer dec = new Integer(convertToDec(intEq));
            
            // Display the result
            JOptionPane.showMessageDialog(null, dec);
            System.exit(0);
        } catch (InvalidHexException e) {
            JOptionPane.showMessageDialog(null, "InvalidHexException is caught: Enter valid hex value");
        }
        System.exit(0);
    }
}

