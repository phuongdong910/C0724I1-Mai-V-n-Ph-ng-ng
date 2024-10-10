package management;

import entities.MedicalRecord;
import entities.NormalPatient;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FILE_PATH = "medical_record.csv";

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

    public static List<MedicalRecord> readMedicalRecords() {
        List<MedicalRecord> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 8) { // Check for correct number of columns
                    String id = values[0];
                    String name = values[1];
                    int age = Integer.parseInt(values[2]);
                    String gender = values[3];
                    String diagnosis = values[4];
                    LocalDate admissionDate = LocalDate.parse(values[5]);
                    LocalDate dischargeDate = LocalDate.parse(values[6]);
                    String status = values[7];

                    MedicalRecord record = new NormalPatient(id, name, age, gender, diagnosis,
                            admissionDate, dischargeDate, status);
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return records;
    }

    public static boolean deleteMedicalRecord(String recordId) {
        List<String> records = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 1 && !values[0].equals(recordId)) {
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
