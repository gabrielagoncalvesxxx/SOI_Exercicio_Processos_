package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RedesController {
    private String os() {
        return System.getProperty("os.name").toLowerCase();
    }
    public void ip() {
        String os = os();
        ProcessBuilder processBuilder;
        if (os.contains("win")) {
            processBuilder = new ProcessBuilder("cmd.exe", "/c", "ipconfig");
        } else {
            processBuilder = new ProcessBuilder("sh", "-c", "ifconfig");
        }

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("IPv4") || line.contains("inet")) {
                    System.out.println(line.trim());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ping() {
        String os = os();
        ProcessBuilder processBuilder;
        if (os.contains("win")) {
            processBuilder = new ProcessBuilder("cmd.exe", "/c", "ping -n 10 www.google.com.br");
        } else {
            processBuilder = new ProcessBuilder("sh", "-c", "ping -c 10 www.google.com.br");
        }

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            long totalTime = 0;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Average") || line.contains("avg")) {
                    String[] parts = line.split(" ");
                    for (String part : parts) {
                        if (part.contains("ms")) {
                            System.out.println("Tempo médio do ping: " + part);
                            break;
                        }
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
