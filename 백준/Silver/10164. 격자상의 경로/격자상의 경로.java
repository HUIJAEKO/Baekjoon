import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        dp[1][1] = 1;

        if (K == 0) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }    
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[N][M]);
            return;
        }

        int kRow = (K - 1) / M + 1;
        int kCol = (K - 1) % M + 1;

        for (int i = 1; i <= kRow; i++) {
            for (int j = 1; j <= kCol; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }    
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int first = dp[kRow][kCol];

        dp = new int[N + 1][M + 1];
        dp[kRow][kCol] = 1;

        for (int i = kRow; i <= N; i++) {
            for (int j = kCol; j <= M; j++) {
                if (i == kRow && j == kCol) {
                    continue;
                }    
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        int second = dp[N][M];

        System.out.println(first * second);
    }
}
