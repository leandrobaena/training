package mypackage;

public class Cat {
	
	public void makeSound() {
		class Kitten {
			public void sayMeow() {
				System.out.println("Meow");
			}
		}
		Kitten kitten = new Kitten();
		kitten.sayMeow();
	}

	public static void main(String[] args) {
		Cat pasha = new Cat();
		pasha.makeSound();
	}
}
