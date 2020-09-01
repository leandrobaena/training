package mypackage;

public class InnerOuter {
	private static int counter = 0;

	private class Inner {
		void incrementA() {
			counter++;
		}
	}
	public void increment() {
		class RealInner extends Inner {
			void incrementA() {
				counter++;
				super.incrementA();
			}
		}	
		new RealInner().incrementA();
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String args[]) {
		InnerOuter x = new InnerOuter();
		x.increment();
		System.out.println(x.getCounter());
	}
 }
