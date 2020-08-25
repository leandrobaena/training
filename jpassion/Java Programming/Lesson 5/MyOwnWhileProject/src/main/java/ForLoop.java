
import javax.swing.JOptionPane;

public class ForLoop {

    /**
     * Creates a new instance of ForLoop
     */
    public ForLoop() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare and initialize String array variable called names.
        String names[] = {"Beah", "Bianca", "Lance", "Belle", "Nico", "Yza", "Gem", "Ethan"};

        // This is the search string we are going to use to search the array.
        String searchName = JOptionPane.showInputDialog("Enter either \"Yza\" or \"noname\"!");

        // Declare and initialize boolean primitive type variable calld foundName.
        boolean foundName = false;

        int i = 0;
        while (i < names.length) {
            if (names[i].equals(searchName)) {
                foundName = true;
                break;
            }
            i++;
        }

        // Display the result
        if (foundName) {
            JOptionPane.showMessageDialog(null, searchName + " is found!");
        } else {
            JOptionPane.showMessageDialog(null, searchName + " is not found!");
        }

    }

}
