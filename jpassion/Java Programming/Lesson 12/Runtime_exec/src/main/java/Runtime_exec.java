
class Runtime_exec {
    
    public static void main(String args[]) {
        
        Runtime rt = Runtime.getRuntime();
        Process proc;
        
        try {
            
            if (System.getProperty("os.name").startsWith("Windows")){
                // Run a OS specific program
                proc = rt.exec("notepad");
            }
            else{
                proc = rt.exec("gedit");
            }
            
            System.out.println("Before calling waitFor() method");
            proc.waitFor();	// try removing this line
            System.out.println("After calling waitFor() method");
        } catch (Exception e) {
            System.out.println("notepad is an unknown command.");
        }
    }
    
}