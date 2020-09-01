package mypackage;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
	}

	// Handle checked exception inside the method
	public static void method1() {

		try {
			throw new FileNotFoundException();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// Pass the checked exception to the calling chain
	public static void method2() throws FileNotFoundException {

		throw new FileNotFoundException();

	}

	// Compile error expected because a checked
	// exception has not been dealt with
	public static void method3() {

		//throw new FileNotFoundException();

	}

}
