import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] dp = new int[10001];
        dp[0] = 1;

        for(int i=1; i<=3; i++){
            for(int j=i; j<10001; j++){
                dp[j] += dp[j-i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = input.nextInt();
            sb.append(dp[num]).append("\n");
        }

        System.out.println(sb);
    }
}
