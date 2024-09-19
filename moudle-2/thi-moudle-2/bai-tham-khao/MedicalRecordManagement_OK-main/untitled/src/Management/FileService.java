package Management;

import Entities.MedicalRecord;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FILE_PATH = "medical_records.csv";

    static {
        createFileIfNotExists();
    }

    private static void createFileIfNotExists() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + FILE_PATH);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public static void saveMedicalRecord(MedicalRecord record) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(record.toCsvString());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int getLastOder() {
        int lastOder = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    lastOder = Integer.parseInt(values[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing order number: " + e.getMessage());
        }
        return lastOder;
    }

    public static boolean isRecordIdExists(String recordId) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 1 && values[1].equals(recordId)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
    }

    public static boolean deleteMedicalRecord(String recordId) {
        List<String> records = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 1 && !values[1].equals(recordId)) {
                    records.add(line);
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return false;
        }

        if (!found) {
            return false;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String record : records) {
                writer.println(record);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }

        return true;
    }
}