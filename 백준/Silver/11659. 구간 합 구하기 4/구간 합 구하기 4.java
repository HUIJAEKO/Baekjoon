import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];

        for(int i=1; i<=N ;i++){
            arr[i] = input.nextInt();
            sum[i] = sum[i-1] + arr[i];

        }

        for(int i=0; i<M; i++) {
            int first = input.nextInt();
            int last = input.nextInt();
            System.out.println(sum[last] - sum[first-1]);
        }
    }
}