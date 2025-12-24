import java.util.Scanner;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[n][k]);
    }
}
