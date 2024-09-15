import java.util.Scanner;
public class FIndMinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Nhập số phần tử của mảng");
        int size = sc.nextInt();
        int [] array = new int[size];

        System.out.println("Nhập phần tử cho mảng");
        for ( int i = 0; i <size; i++){
            System.out.print("array[" + i + "] = ");
            array[i] = sc.nextInt();
        }

        int min = array [0];

        for ( int i = 1; i <size; i++){
            if( array[i]<min){
                min = array [i];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min);


    }
}
