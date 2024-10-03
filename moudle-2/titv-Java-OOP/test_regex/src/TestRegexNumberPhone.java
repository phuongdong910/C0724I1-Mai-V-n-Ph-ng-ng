import java.util.Scanner;
import java.util.regex.Pattern;

public class TestRegexNumberPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("input phone:");
            String phone = sc.nextLine();

            Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])$");

            if(p.matcher(phone).find()){
                System.out.println("Number phone ok");
                break;
            }else {
                System.err.println("Number phone not ok");
            }
        }
    }
}
