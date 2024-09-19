package Management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewMedicalRecords {
    private static final String FILE_PATH = "medical_records.csv";

    public void displayMedicalRecords() {
        System.out.println("\n--- Danh sách bệnh án ---");
        System.out.printf("%-5s %-10s %-10s %-20s %-15s %-15s %-30s%n",
                "STT", "Mã BA", "Mã BN", "Tên bệnh nhân", "Ngày nhập viện", "Ngày ra viện", "Lý do nhập viện");
        System.out.println("----------------------------------------------------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    System.out.printf("%-5s %-10s %-10s %-20s %-15s %-15s %-30s%n",
                            values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}