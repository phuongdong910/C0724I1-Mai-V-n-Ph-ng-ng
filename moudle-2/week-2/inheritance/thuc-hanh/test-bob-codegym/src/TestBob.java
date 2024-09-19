import java.util.Arrays;

public class TestBob {
    public static void main(String[] args) {
        int[] x = new int[]{1, 3, 5};
        int[] y  = new int[]{0, 5, 7};
        x[0] = x[1] + y[2];
        y[1] = y[2] - x[0];
        System.out.print(Arrays.toString(x));
        System.out.println(y[1]);
    }
}
