import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int subset = 1; subset < (1 << N); subset++) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if ((subset & (1 << i)) != 0) {
                    sum += num[i];
                }
            }

            if (sum == S) {
                count++;
            }
        }

        System.out.println(count);
    }
}
