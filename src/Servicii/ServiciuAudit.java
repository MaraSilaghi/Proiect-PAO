package Servicii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiciuAudit {
    private static ServiciuAudit instance;
    private static final String FILE_PATH = "audit.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private ServiciuAudit() {}

    public static ServiciuAudit getInstance() {
        if (instance == null) {
            instance = new ServiciuAudit();
        }
        return instance;
    }

    public void logAction(String actionName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
            writer.write(actionName + "," + timestamp);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
