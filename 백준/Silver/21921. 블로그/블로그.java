import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visit = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N+1];
        sum[1] = visit[1];
        for (int i=2; i<=N; i++) {
            sum[i] = sum[i-1] + visit[i];
        }

        long max = sum[X];
        long count = 1;
        for (int i=1; i<=N-X; i++) {
            long newN = sum[i+X] - sum[i];
            if (max < newN) {
                count = 1;
                max = newN;
            } else if (max == newN) {
                count++;
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }
}
