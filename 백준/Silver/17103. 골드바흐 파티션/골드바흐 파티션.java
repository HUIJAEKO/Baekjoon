import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        int maxN = 1000000;
        boolean[] isPrime = eratosthenes(maxN);

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            System.out.println(count(N, isPrime));
        }

    }

    public static boolean[] eratosthenes(int maxN) {
        boolean[] isPrime = new boolean[maxN + 1];
        for (int i = 2; i <= maxN; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= maxN; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxN; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static int count(int n, boolean[] isPrime) {
        int count = 0;

        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                count++;
            }
        }

        return count;
    }
}
