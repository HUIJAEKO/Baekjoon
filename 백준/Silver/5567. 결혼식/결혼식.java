import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

       graph = new ArrayList[N+1];
       visited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);

        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visited[1] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int[] prev = q.poll();
            int p = prev[0];
            int d = prev[1];

            if (d >= 2) {
                continue;
            }

            for (int next : graph[p]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.add(new int[]{next, d+1});
                }
            }
        }

        return count;
    }
}
