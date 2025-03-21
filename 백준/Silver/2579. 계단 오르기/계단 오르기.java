import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n+1];
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        if(n==1){
            System.out.println(num[1]);
            return;
        }else if(n==2){
            System.out.println(num[1]+num[2]);
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = num[1];
        dp[2] = num[1] + num[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + num[i-1]) + num[i];
        }

        System.out.println(dp[n]);
    }
}
