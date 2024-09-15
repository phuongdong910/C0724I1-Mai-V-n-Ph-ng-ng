import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        int N = 6;

        arr[0] = 1;
        arr[1] = 5;
        arr[2] = 7;
        arr[3] = 9;
        arr[4] = 11;
        arr[5] = 13;

        System.out.print("Mảng vừa nhập là: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.print(" Nhập phần tử X cần thêm vào: ");
        int X = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn X vào: ");
        int index = scanner.nextInt();

        if (index < 0 || index > arr.length - 1) {
            System.out.println("Không thể chèn phần tử vào vị trí này");
        } else {
            for (int i = N; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = X;
            N++;

            System.out.println("Mảng sau khi đã chèn phần tử " + X+ "vào vị trí " + index + ":");
            for ( int i = 0; i< N; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
