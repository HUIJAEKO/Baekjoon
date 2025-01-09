import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int[] cards = new int[N+1];
        for(int i=1; i<=N; i++){
            cards[i] = input.nextInt();
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=i; j<=N; j++) {
                dp[j] = Math.max(dp[j], cards[i] + dp[j-i]);
            }
        }



        Arrays.sort(dp);
        System.out.println(dp[N]);
    }
}
