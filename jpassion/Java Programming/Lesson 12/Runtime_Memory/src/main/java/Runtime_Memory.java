
class Runtime_Memory {
    
    public static void main(String args[]) {
        
        Runtime rt = Runtime.getRuntime();
        
        long maxMemory = rt.maxMemory();
        long totalMemory = rt.totalMemory();
        System.out.println("Maximum amount of memory that the Java virtual machine will attempt to use = " + maxMemory + " bytes");
        System.out.println("Total amount of memory currently available for current and future objects, measured in bytes = " + totalMemory + " bytes");
   
    }
    
}