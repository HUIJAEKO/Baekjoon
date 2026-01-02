import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            long sum = 0;

            for (int j=0; j<K; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            while (pq.size() >= 2) {
                long a = pq.poll();
                long b = pq.poll();

                sum += (a+b);
                pq.add(a+b);
            }
            
            System.out.println(sum);
        }
    }
}
