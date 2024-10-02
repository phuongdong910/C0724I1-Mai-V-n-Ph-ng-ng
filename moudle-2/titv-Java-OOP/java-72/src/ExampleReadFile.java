import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ExampleReadFile {
    public static void main(String[] args) {
//        File file = new File("E:\\Codegym2024\\moudle-1-6\\moudle-2\\titv-Java-OOP\\java-72\\src\\ReadFile.txt");
//        try {
//            BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
//            String line = null;
//            while (true) {
//                line = br.readLine();
//                if( line ==null){
//                    break;
//                }else {
//                    System.out.println(line);
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        File file2= new File ("E:\\Codegym2024\\moudle-1-6\\moudle-2\\titv-Java-OOP\\java-72\\src\\ReadFile.txt");

        try {
            List<String> allText = Files.readAllLines(file2.toPath(), StandardCharsets.UTF_8);
            for (String line : allText){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
