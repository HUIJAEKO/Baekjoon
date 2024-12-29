import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }

        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i=4; i<=max; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int number : num){
            System.out.println(dp[number]);
        }
    }
}
