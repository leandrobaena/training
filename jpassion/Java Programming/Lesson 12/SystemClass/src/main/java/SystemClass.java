
import java.io.*;

class SystemClass {
    
   public static void main(String args[]) 
                          throws IOException {
       
      int arr1[] = new int[1050000];
      int arr2[] = new int[1050000];
      long startTime, endTime;
      /* initialize arr1 */
      for (int i = 0; i < arr1.length; i++) {
         arr1[i] = i + 1;
      }
      /* copying manually */
      startTime = System.currentTimeMillis();
      for (int i = 0; i < arr1.length; i++) {
         arr2[i] = arr1[i];
      }
      endTime = System.currentTimeMillis();
      System.out.println("Time for manual copy: " + 
                       (endTime-startTime) + " ms.");
      /* using the copy utility provided by java */
      startTime = System.currentTimeMillis();
      System.arraycopy(arr1, 0, arr2, 0, arr1.length);
      endTime = System.currentTimeMillis();
      System.out.println("Time for copy utility provided: " + 
                        (endTime-startTime) + " ms.");
      System.gc();	//force garbage collector to work
      
      System.setIn(new FileInputStream("temp.txt"));
      
      System.exit(0);
   }
}