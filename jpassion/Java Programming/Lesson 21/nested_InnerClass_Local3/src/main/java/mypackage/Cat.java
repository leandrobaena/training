package mypackage;

public class Cat {
	
	public void makeSound() {
		
		final String xString ="xx";
		
		class Kitten {
			public static final String sound ="xsdf";

			public void sayMeow() {
				System.out.println(xString);
			}
		}
		Kitten kitty = new Kitten();
		kitty.sayMeow();
	}

	public static void main(String[] args) {
		Cat pasha = new Cat();
		pasha.makeSound();
	}
}
