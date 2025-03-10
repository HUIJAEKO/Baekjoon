import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if(n==1){
            System.out.println(0);
            return;
        }else if(n==2){
            System.out.println(1);
            return;
        }else if(n==3){
            System.out.println(1);
            return;
        }

        int[] dp = new int[n+1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++){
            int min = -1;
            if(i%2 == 0 && i%3 ==0){
                min = Math.min(dp[i-1], dp[i/2]);
                min = Math.min(min, dp[i/3]) + 1;
                dp[i] = min;
            }else if(i%2 == 0){
                min = Math.min(dp[i-1], dp[i/2]) + 1;
                dp[i] = min;
            }else if(i%3 == 0) {
                min = Math.min(dp[i - 1], dp[i / 3]) + 1;
                dp[i] = min;
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
