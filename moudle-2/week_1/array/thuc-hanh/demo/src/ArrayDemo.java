

public class ArrayDemo {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 6, 5},
                {4, 8, 6},
                {3, 10, 9}
        };

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];  // Cộng các phần tử trên đường chéo trái
        }

        System.out.println("Tổng các phần tử trên đường chéo trái là: " + sum);
    }
}
