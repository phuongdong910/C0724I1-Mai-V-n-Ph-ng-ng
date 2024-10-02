package service;


import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String COMMA = ",";

    /**
     * Write to file
     */
    private static void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeProduct(String pathFile, List<Product> students) {
        List<String> strings = new ArrayList<>();

        for (Product student : students) {
            strings.add(student.convertLine());
        }
        writeToFile(pathFile, strings);
    }

    /**
     * Read from file
     */
    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<Product> readProduct(String pathFile) {
        List<Product> students = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);
        System.out.println(strings);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            students.add(new Product(Integer.parseInt(lines[0]), lines[1]));
        }
        return students;
    }

}
