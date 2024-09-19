import java.sql.SQLOutput;
import java.util.Scanner;
public class CountCharacterInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the String");
        String str = scanner.nextLine();

        System.out.println("Enter the characters to count");
        char character = scanner.next().charAt(0);

        int count = 0;

        for( int i = 0; i< str.length(); i++){
            if(str.charAt(i) == character){
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự " + character+ "trong chuỗi là " + count);


    }
}
