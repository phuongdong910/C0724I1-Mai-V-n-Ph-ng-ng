import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18};
        System.out.println("Mảng ban đầu: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.print("Nhập phần tử cần xóa: ");
        int X = sc.nextInt();

        int index_del = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == X) {
                index_del = i;
                break;
            }
        }

        if (index_del == -1) {
            System.out.println("Phần tử không tồn tại trong mảng");
        } else {
            for (int i = index_del; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            System.out.println("Mảng sao khi xóa phần tử " + X + ":");
            for ( int i = 0; i < arr.length -1; i++){
                System.out.println(arr[i] + " ");
            }
        }

    }
}
