import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long profit = 0;

            for (int j=N-1; j>=0; j--) {
                if (price[j] > max) {
                    max = price[j];
                } else {
                    profit += (max - price[j]);
                }
            }

            System.out.println(profit);
        }
    }
}
