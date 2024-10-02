import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ExampleWriteText {
    public static void main(String[] args) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("E:\\Codegym2024\\moudle-1-6\\moudle-2\\titv-Java-OOP\\java-71\\src\\Luu.txt", StandardCharsets.UTF_8);

            pw.println("Hello my boy");
            pw.println("Data: ");
            pw.print("3.14");
            pw.println("Hello my boy");
            pw.println("Data: ");
            pw.print("3.14");
            pw.println("Hello my boy");
            pw.println("Data: ");
            pw.print("3.14");
            pw.println("Hello my boy");
            pw.println("Data: ");
            pw.println("3.14");

            Product pd1= new Product("Equipment", 1579.1 );
            pw.println(pd1);

            pw.flush();
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
