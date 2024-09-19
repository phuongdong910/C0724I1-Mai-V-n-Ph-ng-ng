import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string1;
        System.out.println("Nhập vào chuỗi: ");
        string1 = sc.nextLine();
        System.out.println("------");

        // Hàm length
        System.out.println(string1.length());
        int doDai = string1.length();
        //charAt - lấy  ra ký tự tại 1 vị tri

        for (int i = 0; i < doDai; i++) {
            System.out.println("Vị trí " + i + " là: " + string1.charAt(i));
        }

        // hàm Get char ( start, end, arr, index start save arr)

        char[] arrayChar = new char[15];
        string1.getChars(3, 6, arrayChar, 0);
        for (int i = 0; i < arrayChar.length; i++) {
            System.out.println("Giá trị của mảng tại vị tri " + i + " là: " + arrayChar[i]);
        }
        byte[] arrayByte = string1.getBytes();
        for (byte b : arrayByte) {
            System.out.println(b);
        }

    }
}
