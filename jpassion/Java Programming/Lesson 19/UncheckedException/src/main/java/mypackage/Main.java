package mypackage;


public class Main {

	/** Creates a new instance of Main */
	public Main() {
	}

	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main(String[] args) {
		// ArithmeticException does not need to be caught
		// because is a subclass of RunTimeException
		throw new ArithmeticException();
		
	}

}
