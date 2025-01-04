import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int LIMIT = 1000000;
        boolean[] isPrime = new boolean[LIMIT + 1];

        for (int i = 2; i <= LIMIT; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(LIMIT); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Scanner input = new Scanner(System.in);

        while (input.hasNextInt()) {
            int n = input.nextInt();
            if (n == 0) {
                break;
            }

            boolean found = false;
            for (int left = 3; left <= n / 2; left++) {
                int right = n - left;
                if (isPrime[left] && isPrime[right]) {
                    System.out.println(n + " = " + left + " + " + right);
                    found = true;
                    break;
                }
            }

   
        }
    }
}
