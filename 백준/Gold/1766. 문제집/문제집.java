import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] degree = new int[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            arr[first].add(last);
            degree[last]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=N; i++) {
            if (degree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int last : arr[cur]) {
                degree[last]--;
                if (degree[last] == 0) {
                    pq.add(last);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
