import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int result = getMinimumCoins(n);

        System.out.println(result);
    }

    public static int getMinimumCoins(int n) {
        if (n == 1 || n == 3) {
            return -1;
        }

        int countOf5 = n / 5;
        int remainder = n % 5;

        while (countOf5 >= 0) {
            if (remainder % 2 == 0) {
                int countOf2 = remainder / 2;
                return countOf5 + countOf2; 
            }
            countOf5--; 
            remainder += 5;
        }

        return -1;
    }
}