import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N;
    static int M;
    static int X;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        int[] distFromX = dijkstra(X);
        int answer = 0;
        for (int i=1; i<=N; i++) {
            int[] dist = dijkstra(i);
            answer = Math.max(answer, dist[X] + distFromX[i]);
        }

        System.out.println(answer);
    }

    static int[] dijkstra (int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.weight > dist[current.to]) {
                continue;
            }

            for (Node next : graph[current.to]) {
                int nd = current.weight + next.weight;
                if (nd < dist[next.to]) {
                    dist[next.to] = nd;
                    pq.add(new Node(next.to, nd));
                }
            }
        }

        return dist;
    }
}
