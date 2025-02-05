import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int MOD = 1000000009;
        int n = input.nextInt();
        int[] test = new int[n];

        int max = 0;
        for(int i=0; i<n; i++){
            test[i] = input.nextInt();
            max = Math.max(max, test[i]);
        }

        long[] dp = new long[max+1];
        dp[0] = 1;
        if(max >= 1){
            dp[1] = 1;    
        }
        if(max >= 2){
            dp[2] = 2;
        }

        for(int i=3; i<dp.length; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : test) {
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}