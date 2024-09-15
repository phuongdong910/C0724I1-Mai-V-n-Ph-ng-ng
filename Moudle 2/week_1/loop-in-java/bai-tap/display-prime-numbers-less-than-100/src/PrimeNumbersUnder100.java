public class PrimeNumbersUnder100 {
    public static void main(String[] args) {

        System.out.println("Các số nguyên tố nhỏ hơn 100 là:");

        for( int i =2; i < 100; i++){
            if (isPrime(i)){
                System.out.println( i + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        // Kiểm tra xem num có chia hết cho bất kỳ số nào từ 2 đến căn bậc 2 của num không
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
