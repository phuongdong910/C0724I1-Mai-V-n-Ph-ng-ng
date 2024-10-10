package service;

import entities.Mobile;
import entities.OfficialMobile;
import entities.ImportedMobile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {


    public static List<Mobile> readMobilesFromCSV(String filePath) {
        List<Mobile> mobiles = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return mobiles; // Trả về danh sách rỗng nếu file không tồn tại
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(","); // Tách các trường bằng dấu phẩy

                if (fields.length < 6) continue;

                String id = fields[0].trim();
                String name = fields[1].trim();
                double price = Double.parseDouble(fields[2].trim());
                int quantity = Integer.parseInt(fields[3].trim());
                String manufacturer = fields[4].trim();
                String warrantyOrCountry = fields[5].trim(); // Trường này sẽ là warranty hoặc quốc gia
                String statusOrScope = fields.length > 6 ? fields[6].trim() : ""; // Trường thứ 6 (phạm vi hoặc trạng thái)

                // Xác định loại di động dựa trên nội dung của warrantyOrCountry
                if (isNumeric(warrantyOrCountry)) {
                    // Nếu warrantyOrCountry là số, đây là OfficialMobile
                    int warrantyPeriod = Integer.parseInt(warrantyOrCountry);
                    OfficialMobile officialMobile = new OfficialMobile(id, name, price, quantity, manufacturer, warrantyPeriod, statusOrScope);
                    mobiles.add(officialMobile);
                } else {
                    // Nếu không, đây là ImportedMobile
                    ImportedMobile importedMobile = new ImportedMobile(id, name, price, quantity, manufacturer, warrantyOrCountry, statusOrScope);
                    mobiles.add(importedMobile);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
        return mobiles;
    }

    public static void writeMobilesToCSV(List<Mobile> mobiles, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Mobile mobile : mobiles) {
                bw.write(mobile.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
