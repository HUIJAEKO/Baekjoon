import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snack = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        int left = 1;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;

            for (int s : snack) {
                count += s / mid;
            }

            if (count >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
