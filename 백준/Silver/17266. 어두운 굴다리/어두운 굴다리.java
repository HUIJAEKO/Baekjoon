import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] x = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        int max = x[0];

        for(int i=1; i<M; i++){
            max = Math.max(max, (x[i] - x[i-1] + 1) / 2);
        }

        max = Math.max(max, N - x[M - 1]);

        System.out.println(max);
    }
}
