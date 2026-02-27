import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dist = new int[y + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        dist[x] = 0;
        q.offer(x);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == y) {
                return dist[cur];
            }

            int[] nexts = new int[] { cur + n, cur * 2, cur * 3 };

            for (int next : nexts) {
                if (next <= y && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        return -1;
    }
}