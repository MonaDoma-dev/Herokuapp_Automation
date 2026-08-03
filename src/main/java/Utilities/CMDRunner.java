package Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMDRunner {

    public static int executeCommand(String command) {
        int exitCode = -1;
        try {
            ProcessBuilder builder = new ProcessBuilder();
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                builder.command("cmd.exe", "/c", command);
            } else {
                builder.command("sh", "-c", command);
            }

            builder.redirectErrorStream(true);
            Process process = builder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[CMD Output] " + line);
                }
            }
            exitCode = process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exitCode;
    }

    public static void ExecuteCommand(String command) {
        executeCommand(command);
    }
}