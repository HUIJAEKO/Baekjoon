import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for (int d : dist) {
            max = Math.max(max, d);
        }
        
        int count = 0;
        for (int d : dist) {
            if (d == max) count++;
        }
        
        return count;
    }
}