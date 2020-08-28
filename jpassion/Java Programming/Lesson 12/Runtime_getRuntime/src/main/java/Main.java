import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {

        String[] commandArray = {"javap", "-private",
            "java.lang.String"};
        String[] environment = {"path=;",
            "path=C:\\Java\\jdk1.7.0_25\\bin;"};

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commandArray, environment);
        writeProcessOutput(process);
    }

    static void writeProcessOutput(Process process) throws Exception {
        InputStreamReader tempReader = new InputStreamReader(
                new BufferedInputStream(process.getInputStream()));
        BufferedReader reader = new BufferedReader(tempReader);
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}
