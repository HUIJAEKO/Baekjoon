import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i=0; i<m; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;

            pq.add(sum);
            pq.add(sum);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
