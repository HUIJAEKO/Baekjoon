import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        long cost;

        Node (int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo (Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] graph = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Long.parseLong(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        long[] minCost = new long[N];
        Arrays.fill(minCost, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        minCost[0] = 0;
        pq.offer(new Node(0, 0));
        long result = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.index;

            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;

            result += now.cost;

            for (int next=0; next<N; next++) {
                if (!visited[next] && graph[cur][next] < minCost[next]) {
                    minCost[next] = graph[cur][next];
                    pq.offer(new Node(next, graph[cur][next]));
                }
            }
        }

        System.out.println(result);
    }
}
