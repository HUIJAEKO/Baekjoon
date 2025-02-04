import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int start = 0;
        int end = 0;
        int minDiff = Integer.MAX_VALUE;

        while (end < N) {
            int diff = A[end] - A[start];

            if (diff >= M) {
                minDiff = Math.min(minDiff, diff);
                start++; 
            } else {
                end++;    
            }

            if (start > end) {
                end = start;
            }
        }

        System.out.println(minDiff);
    }
}
