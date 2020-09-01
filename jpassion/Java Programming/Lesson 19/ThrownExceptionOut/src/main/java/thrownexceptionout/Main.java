package thrownexceptionout;

public class Main {
  public static void main(String[] args) throws Throwable {
    try {
      throw new Throwable();
    } catch (Exception e) {
      System.err.println("Caught in main()");
    }
  }
} 